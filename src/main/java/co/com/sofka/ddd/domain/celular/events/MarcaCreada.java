package co.com.sofka.ddd.domain.celular.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.values.MarcaId;
import co.com.sofka.ddd.domain.celular.values.NombreMarca;
import co.com.sofka.ddd.domain.celular.values.Descuento;

public class MarcaCreada extends DomainEvent {

    private final MarcaId marcaId;
    private final NombreMarca nombreMarca;
    private final Descuento descuento;

    public MarcaCreada(MarcaId marcaId, NombreMarca nombreMarca, Descuento descuento){
        super("retoddd.celular.marcacreada");
        this.marcaId = marcaId;
        this.nombreMarca = nombreMarca;
        this.descuento = descuento;
    }

    public MarcaId getMarcaId() {
        return marcaId;
    }

    public NombreMarca getNombreMarca() {
        return nombreMarca;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
