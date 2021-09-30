package co.com.sofka.ddd.domain.celular.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ddd.domain.celular.values.CelularId;
import co.com.sofka.ddd.domain.celular.values.NombreCelular;
import co.com.sofka.ddd.domain.celular.values.Precio;

public class CrearCelular implements Command {

    private final CelularId entityId;
    private final NombreCelular nombreCelular;
    private final Precio precio;

    public CrearCelular(CelularId entityId, NombreCelular nombreCelular, Precio precio){

        this.entityId = entityId;
        this.nombreCelular = nombreCelular;
        this.precio = precio;
    }

    public CelularId getEntityId() {
        return entityId;
    }

    public NombreCelular getNombreCelular() {
        return nombreCelular;
    }

    public Precio getPrecio() {
        return precio;
    }
}
