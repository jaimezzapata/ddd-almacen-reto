package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.commands.CrearMarca;
import co.com.sofka.ddd.domain.celular.events.CelularCreado;
import co.com.sofka.ddd.domain.celular.events.MarcaCreada;
import co.com.sofka.ddd.domain.celular.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrearMarcaUseCaseTest {

    private CrearMarcaUseCase crearMarcaUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        crearMarcaUseCase = new CrearMarcaUseCase();
        repository = mock(DomainEventRepository.class);
        crearMarcaUseCase.addRepository(repository);
    }

    @Test
    void crearMarcaHappyPath(){
        var command = new CrearMarca(
                CelularId.of("xxxx"),
                MarcaId.of("zzzz"),
                new NombreMarca("Apple"),
                new Descuento(0.05)
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(
                        crearMarcaUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var events =(MarcaCreada)response.getDomainEvents().get(0);

        Assertions.assertEquals("zzzz", events.getMarcaId().value());
        Assertions.assertEquals("Apple", events.getNombreMarca().value());
        Assertions.assertEquals(0.05, events.getDescuento().value());
    }

    private List<DomainEvent> events() {
        return List.of(new CelularCreado(
                new NombreCelular("Iphone 11"),
                new Precio(3500000)
        ));
    }
}
