package co.com.sofka.ddd.domain.celular.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ddd.domain.celular.values.Capacidad;
import co.com.sofka.ddd.domain.celular.values.CategoriaId;
import co.com.sofka.ddd.domain.celular.values.CelularId;

public class ActualizarCapacidad implements Command {

    private final CelularId celularId;
    private final CategoriaId categoriaId;
    private final Capacidad capacidad;

    public ActualizarCapacidad(CelularId celularId, CategoriaId categoriaId, Capacidad capacidad) {
        this.celularId = celularId;
        this.categoriaId = categoriaId;
        this.capacidad = capacidad;
    }

    public CelularId getCelularId() {
        return celularId;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}
