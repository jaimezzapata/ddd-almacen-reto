package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.domain.celular.commands.CrearCelular;
import co.com.sofka.ddd.domain.celular.events.CelularCreado;
import co.com.sofka.ddd.domain.celular.values.CelularId;
import co.com.sofka.ddd.domain.celular.values.NombreCelular;
import co.com.sofka.ddd.domain.celular.values.Precio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CrearCelularUseCaseTest {

    private CrearCelularUseCase crearCelularUseCase;

    @BeforeEach
    public void setup(){
        crearCelularUseCase = new CrearCelularUseCase();
    }

    @Test
    void crearCelularhappyPath(){
        var command = new CrearCelular(
                CelularId.of("xxxxzzzzzz"),
                new NombreCelular("Galaxy"),
                new Precio(2100000)
        );

        var response = UseCaseHandler.getInstance().syncExecutor(
                crearCelularUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var events = response.getDomainEvents();


        CelularCreado celularCreado = (CelularCreado)events.get(0);
        Assertions.assertEquals("Galaxy", celularCreado.getNombreCelular().value());
        Assertions.assertEquals(2100000, celularCreado.getPrecio().value());
    }
}
