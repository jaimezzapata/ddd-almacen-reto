package co.com.sofka.ddd.domain.almacen.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.almacen.values.NombreAlmacen;

public class AlmacenCreado extends DomainEvent {

    private final NombreAlmacen nombreAlmacen;

    public AlmacenCreado(NombreAlmacen nombreAlmacen) {
        super("sofka.almacen.almacencreado");

        this.nombreAlmacen = nombreAlmacen;
    }

    public NombreAlmacen getNombreAlmacen() {
        return nombreAlmacen;
    }
}
