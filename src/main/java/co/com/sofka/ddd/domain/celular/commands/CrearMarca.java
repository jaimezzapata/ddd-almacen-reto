package co.com.sofka.ddd.domain.celular.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ddd.domain.celular.values.CelularId;
import co.com.sofka.ddd.domain.celular.values.Descuento;
import co.com.sofka.ddd.domain.celular.values.MarcaId;
import co.com.sofka.ddd.domain.celular.values.NombreMarca;

public class CrearMarca implements Command {

    private final CelularId celularId;
    private final MarcaId marcaId;
    private final NombreMarca nombreMarca;
    private final Descuento descuento;

    public CrearMarca(CelularId celularId, MarcaId marcaId, NombreMarca nombreMarca, Descuento descuento) {
        this.celularId = celularId;
        this.marcaId = marcaId;
        this.nombreMarca = nombreMarca;
        this.descuento = descuento;
    }

    public CelularId getCelularId() {
        return celularId;
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
