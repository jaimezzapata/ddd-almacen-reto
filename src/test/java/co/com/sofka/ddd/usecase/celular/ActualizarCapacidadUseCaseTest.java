package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.commands.ActualizarCapacidad;
import co.com.sofka.ddd.domain.celular.events.CapacidadActualizada;
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

public class ActualizarCapacidadUseCaseTest {

    private ActualizarCapacidadUseCase actualizarCapacidadUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup(){
        actualizarCapacidadUseCase = new ActualizarCapacidadUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarCapacidadUseCase.addRepository(repository);
    }

    @Test
    void actualizarProcesadorHappyPath() {
        var command = new ActualizarCapacidad(
                CelularId.of("xxx"),
                CategoriaId.of("zzz"),
                new Capacidad("128GB")
        );
        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .syncExecutor(
                        actualizarCapacidadUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var event = (CapacidadActualizada)response.getDomainEvents().get(0);

        Assertions.assertEquals("128GB",event.getCapacidad().value());
    }

    private List<DomainEvent> events() {
        return List.of(new CelularCreado(
                new NombreCelular("Galaxy S21"),
                new Precio(2900000)
        ),new CategoriaCreada(
                CategoriaId.of("zzz"),
                new Gama("Baja"),
                new Procesador("OctaCore"),
                new Capacidad("256 GB"),
                new Tamaño("6.5 pulgadas")
        ));
    }
}
