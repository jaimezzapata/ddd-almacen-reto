package co.com.sofka.ddd.domain.celular.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.values.CelularId;
import co.com.sofka.ddd.domain.celular.values.NombreCelular;

public class NombreCelularActualizado extends DomainEvent {
    private final CelularId celularId;
    private final NombreCelular nombreCelular;

    public NombreCelularActualizado(CelularId celularId, NombreCelular nombreCelular) {
        super("sofka.celular.nombrecelularactualizado");
        this.celularId = celularId;
        this.nombreCelular = nombreCelular;
    }

    public CelularId getCelularId() {
        return celularId;
    }

    public NombreCelular getNombreCelular() {
        return nombreCelular;
    }
}
