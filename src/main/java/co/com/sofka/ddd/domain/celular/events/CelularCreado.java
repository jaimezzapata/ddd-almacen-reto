package co.com.sofka.ddd.domain.celular.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.values.NombreCelular;
import co.com.sofka.ddd.domain.celular.values.Precio;

public class CelularCreado  extends DomainEvent {

    private final NombreCelular nombreCelular;
    private final Precio precio;

    public CelularCreado(NombreCelular nombreCelular, Precio precio) {
        super("retoddd.celular.celularcreado");
        this.nombreCelular = nombreCelular;
        this.precio = precio;
    }

    public NombreCelular getNombreCelular() {
        return nombreCelular;
    }

    public Precio getPrecio() {
        return precio;
    }
}
