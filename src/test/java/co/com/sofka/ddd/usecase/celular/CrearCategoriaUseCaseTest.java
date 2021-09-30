package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.commands.CrearCategoria;
import co.com.sofka.ddd.domain.celular.events.CategoriaCreada;
import co.com.sofka.ddd.domain.celular.events.CelularCreado;
import co.com.sofka.ddd.domain.celular.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrearCategoriaUseCaseTest {

    CrearCategoriaUseCase crearCategoriaUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup(){
        crearCategoriaUseCase = new CrearCategoriaUseCase();
        repository = mock(DomainEventRepository.class);
        crearCategoriaUseCase.addRepository(repository);
    }

    @Test
    void crearCategoriaHappyPath(){
        var command = new CrearCategoria(
                CelularId.of("xxxx"),
                CategoriaId.of("zzzz"),
                new Gama("Alta"),
                new Procesador("A1"),
                new Capacidad("128GB"),
                new Tamaño("6 pulgada")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .syncExecutor(
                        crearCategoriaUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var events = (CategoriaCreada)response.getDomainEvents().get(0);

        Assertions.assertEquals("zzzz", events.getCategoriaId().value());
        Assertions.assertEquals("Alta", events.getGama().value());
        Assertions.assertEquals("A1", events.getProcesador().value());
        Assertions.assertEquals("128GB", events.getCapacidad().value());
        Assertions.assertEquals("6 pulgada", events.getTamaño().value());

    }

    private List<DomainEvent> events() {
        return List.of(new CelularCreado(
                new NombreCelular("Iphone 11"),
                new Precio(3500000)
        ));
    }
}
