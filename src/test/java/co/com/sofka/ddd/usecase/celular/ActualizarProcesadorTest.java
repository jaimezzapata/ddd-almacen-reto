package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.commands.ActualizarProcesador;
import co.com.sofka.ddd.domain.celular.events.CategoriaCreada;
import co.com.sofka.ddd.domain.celular.events.CelularCreado;
import co.com.sofka.ddd.domain.celular.events.ProcesadorActualizado;
import co.com.sofka.ddd.domain.celular.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarProcesadorTest {

    private ActualizarProcesadorUseCase actualizarProcesadorUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup() {
        actualizarProcesadorUseCase = new ActualizarProcesadorUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarProcesadorUseCase.addRepository(repository);
    }

    @Test
    void actualizarProcesadorHappyPath(){
        var command = new ActualizarProcesador(
                CelularId.of("xxx"),
                CategoriaId.of("zzz"),
                new Procesador("SnapDragon"),
                ReceiverId.of("aaa")
        );
        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .syncExecutor(
                        actualizarProcesadorUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var event = (ProcesadorActualizado)response.getDomainEvents().get(0);

        Assertions.assertEquals("SnapDragon",event.getProcesador().value());
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
