package co.com.sofka.ddd.domain.celular.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.values.*;

public class PrecioCelularCalculado extends DomainEvent {


    private final CelularId celularId;
    private final Precio precio;
    private final MarcaId marcaId;
    private final Gama gama;
    private final Procesador procesador;
    private final Descuento descuento;

    public PrecioCelularCalculado(CelularId celularId, Precio precio, MarcaId marcaId, Gama gama, Procesador procesador, Descuento descuento) {
        super("sofka.celular.preciocelularcalculado");
        this.celularId = celularId;
        this.precio = precio;
        this.marcaId = marcaId;
        this.gama = gama;
        this.procesador = procesador;
        this.descuento = descuento;
    }

    public CelularId getCelularId() {
        return celularId;
    }

    public Precio getPrecio() {
        return precio;
    }

    public MarcaId getMarcaId() {
        return marcaId;
    }

    public Gama getGama() {
        return gama;
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
