package co.com.sofka.ddd.domain.celular.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.values.Descuento;
import co.com.sofka.ddd.domain.celular.values.MarcaId;
import co.com.sofka.ddd.domain.celular.values.NombreMarca;

public class DescuentoCalculado extends DomainEvent {


    private final MarcaId marcaId;
    private final NombreMarca nombreMarca;
    private final Descuento descuento;

    public DescuentoCalculado(MarcaId marcaId, NombreMarca nombreMarca, Descuento descuento) {
        super("sofka.celular.descuentocalculado");
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
