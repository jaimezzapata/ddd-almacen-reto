package co.com.sofka.ddd.usecase.almacen;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.domain.almacen.commands.CrearAlmacen;
import co.com.sofka.ddd.domain.almacen.events.AlmacenCreado;
import co.com.sofka.ddd.domain.almacen.values.AlmacenId;
import co.com.sofka.ddd.domain.almacen.values.NombreAlmacen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearAlmacenUseCaseTest {

    private CrearAlmacenUseCase crearAlmacenUseCase;

    @BeforeEach
    public void setup() { crearAlmacenUseCase = new CrearAlmacenUseCase();}

    @Test
    void crearAlmacenHappyPath(){
        var command = new CrearAlmacen(
                AlmacenId.of("a1df4g4g"),
                new NombreAlmacen("Alkosto")
        );

        var response = UseCaseHandler.getInstance().syncExecutor(
                crearAlmacenUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var events = response.getDomainEvents();

        AlmacenCreado almacenCreado = (AlmacenCreado) events.get(0);
        Assertions.assertEquals("Alkosto", almacenCreado.getNombreAlmacen().value());
    }
}
