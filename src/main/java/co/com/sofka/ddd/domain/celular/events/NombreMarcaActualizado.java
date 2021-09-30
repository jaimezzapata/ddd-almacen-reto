package co.com.sofka.ddd.domain.celular.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.values.MarcaId;
import co.com.sofka.ddd.domain.celular.values.NombreMarca;

public class NombreMarcaActualizado extends DomainEvent {

    private final MarcaId marcaId;
    private final NombreMarca nombreMarca;

    public NombreMarcaActualizado(MarcaId marcaId, NombreMarca nombreMarca) {
        super("sofka.celular.nombremarcaactualizado");
        this.marcaId = marcaId;
        this.nombreMarca = nombreMarca;
    }

    public MarcaId getMarcaId() {
        return marcaId;
    }

    public NombreMarca getNombreMarca() {
        return nombreMarca;
    }
}
