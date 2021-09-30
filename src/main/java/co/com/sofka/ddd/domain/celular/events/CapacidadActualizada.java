package co.com.sofka.ddd.domain.celular.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.values.Capacidad;
import co.com.sofka.ddd.domain.celular.values.CategoriaId;

public class CapacidadActualizada  extends DomainEvent {

    private final CategoriaId categoriaId;
    private final Capacidad capacidad;

    public CapacidadActualizada(CategoriaId categoriaId, Capacidad capacidad) {
        super("sofka.celular.capacidadactualizada");
        this.categoriaId = categoriaId;
        this.capacidad = capacidad;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}
