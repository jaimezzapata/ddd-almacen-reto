package co.com.sofka.ddd.domain.celular;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.ddd.domain.celular.values.*;

import java.util.Objects;

public class Categoria extends Entity<CategoriaId> {

    protected CategoriaId categoriaId;
    protected Capacidad capacidad;
    protected Gama gama;
    protected Procesador procesador;
    protected Tamaño tamaño;

    public Categoria(CategoriaId categoriaId, Capacidad capacidad, Gama gama, Procesador procesador, Tamaño tamaño) {
        super(categoriaId);
        this.categoriaId = categoriaId;
        this.capacidad = capacidad;
        this.gama = gama;
        this.procesador = procesador;
        this.tamaño = tamaño;
    }

    public void actualizarGama(Gama gama){ this.gama = Objects.requireNonNull(gama);}
    public void actualizarCapacidad(Capacidad capacidad){ this.capacidad = Objects.requireNonNull(capacidad);}
    public void actualizarProcesador(Procesador procesador){ this.procesador = Objects.requireNonNull(procesador);}

    public CategoriaId categoriaId() {
        return categoriaId;
    }

    public Capacidad capacidad() {
        return capacidad;
    }

    public Gama gama() {
        return gama;
    }

    public Procesador procesador() {
        return procesador;
    }

    public Tamaño tamaño() {
        return tamaño;
    }
}
