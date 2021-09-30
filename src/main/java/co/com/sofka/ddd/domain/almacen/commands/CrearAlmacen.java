package co.com.sofka.ddd.domain.almacen.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ddd.domain.almacen.values.AlmacenId;
import co.com.sofka.ddd.domain.almacen.values.NombreAlmacen;

public class CrearAlmacen implements Command {

    private final AlmacenId almacenId;
    private final NombreAlmacen nombreAlmacen;

    public CrearAlmacen(AlmacenId almacenId, NombreAlmacen nombreAlmacen) {
        this.almacenId = almacenId;
        this.nombreAlmacen = nombreAlmacen;
    }

    public AlmacenId getAlmacenId() {
        return almacenId;
    }

    public NombreAlmacen getNombreAlmacen() {
        return nombreAlmacen;
    }
}
