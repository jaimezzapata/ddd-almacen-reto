package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.commands.ActualizarNombreCelular;
import co.com.sofka.ddd.domain.celular.events.CelularCreado;
import co.com.sofka.ddd.domain.celular.events.NombreCelularActualizado;
import co.com.sofka.ddd.domain.celular.values.CelularId;
import co.com.sofka.ddd.domain.celular.values.NombreCelular;
import co.com.sofka.ddd.domain.celular.values.Precio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarNombreCelularUseCaseTest {

    ActualizarNombreCelularUseCase actualizarNombreCelularUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup(){
        actualizarNombreCelularUseCase = new ActualizarNombreCelularUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarNombreCelularUseCase.addRepository(repository);
    }

    @Test
    void actualizarNombreCelularHappyPath(){
        var command = new ActualizarNombreCelular(
                CelularId.of("xxxx"),
                new NombreCelular("Iphone X")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .syncExecutor(
                        actualizarNombreCelularUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var events = (NombreCelularActualizado)response.getDomainEvents().get(0);

        Assertions.assertEquals("xxxx", events.getCelularId().value());
        Assertions.assertEquals("Iphone X", events.getNombreCelular().value());
    }

    private List<DomainEvent> events() {
        return List.of(new CelularCreado(
                new NombreCelular("Iphone 11"),
                new Precio(3500000)
        ));
    }
}
