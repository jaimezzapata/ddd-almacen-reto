package co.com.sofka.ddd.domain.celular.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ddd.domain.celular.values.*;

public class CrearCategoria implements Command {

    private final CelularId celularId;
    private final CategoriaId categoriaId;
    private final Gama gama;
    private final Procesador procesador;
    private final Capacidad capacidad;
    private final Tamaño tamaño;

    public CrearCategoria(CelularId celularId, CategoriaId categoriaId, Gama gama, Procesador procesador, Capacidad capacidad, Tamaño tamaño) {
        this.celularId = celularId;
        this.categoriaId = categoriaId;
        this.gama = gama;
        this.procesador = procesador;
        this.capacidad = capacidad;
        this.tamaño = tamaño;
    }

    public CelularId getCelularId() {
        return celularId;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public Gama getGama() {
        return gama;
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public Tamaño getTamaño() {
        return tamaño;
    }
}
