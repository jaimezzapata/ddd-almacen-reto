package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.commands.CrearOperador;
import co.com.sofka.ddd.domain.celular.events.CelularCreado;
import co.com.sofka.ddd.domain.celular.events.OperadorCreado;
import co.com.sofka.ddd.domain.celular.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrearOperadorUseCaseTest {

    CrearOperadorUseCase crearOperadorUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup(){
        crearOperadorUseCase = new CrearOperadorUseCase();
        repository = mock(DomainEventRepository.class);
        crearOperadorUseCase.addRepository(repository);
    }

    @Test
    void crearOperadorHappyPath(){
        var command = new CrearOperador(
                CelularId.of("xxx"),
                OperadorId.of("zzz"),
                new TipoServicio("pospago"),
                new ValorPlan(50000),
                new NombreOperador("Claro")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .syncExecutor(
                        crearOperadorUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var events = (OperadorCreado)response.getDomainEvents().get(0);

        Assertions.assertEquals("zzz", events.getOperadorId().value());
        Assertions.assertEquals("Claro", events.getNombreOperador().value());
        Assertions.assertEquals("pospago", events.getTipoServicio().value());
        Assertions.assertEquals(50000, events.getValorPlan().value());

    }

    private List<DomainEvent> events() {
        return List.of(new CelularCreado(
                new NombreCelular("Iphone 11"),
                new Precio(3500000)
        ));
    }
}
