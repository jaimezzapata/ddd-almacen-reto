package co.com.sofka.ddd.domain.celular.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.values.*;

public class CategoriaCreada extends DomainEvent {

    private final CategoriaId categoriaId;
    private final Gama gama;
    private final Procesador procesador;
    private final Capacidad capacidad;
    private final Tamaño tamaño;

    public CategoriaCreada(CategoriaId categoriaId, Gama gama, Procesador procesador, Capacidad capacidad, Tamaño tamaño) {
        super("sofka.celular.categoriacreada");
        this.categoriaId = categoriaId;
        this.gama = gama;
        this.procesador = procesador;
        this.capacidad = capacidad;
        this.tamaño = tamaño;
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
