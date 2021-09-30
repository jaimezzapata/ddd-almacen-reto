package co.com.sofka.ddd.domain.celular;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.events.*;
import co.com.sofka.ddd.domain.celular.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Celular extends AggregateEvent<CelularId> {

    protected NombreCelular nombreCelular;
    protected Precio precio;
    protected Set<Marca> marcas;
    protected Set<Categoria> categorias;
    protected Set<Operador> operadores;

    public Celular(CelularId entityId, NombreCelular nombreCelular, Precio precio) {

        super(entityId);
        appendChange(new CelularCreado(nombreCelular, precio)).apply();
    }

    public Celular(CelularId celularId){
        super(celularId);
        subscribe(new CelularChange(this));
    }

    public static Celular from(CelularId celularId, List<DomainEvent> events){
        var celular = new Celular(celularId);
        events.forEach(celular::applyEvent);
        return celular;
    }

    public void crearMarca(MarcaId marcaId, NombreMarca nombreMarca, Descuento descuento){
        Objects.requireNonNull(marcaId);
        Objects.requireNonNull(nombreMarca);
        Objects.requireNonNull(descuento);
        appendChange(new MarcaCreada(marcaId, nombreMarca, descuento)).apply();
    }

    public void crearCategoria(CategoriaId categoriaId, Gama gama, Procesador procesador, Capacidad capacidad, Tamaño tamaño){
        Objects.requireNonNull(categoriaId);
        Objects.requireNonNull(gama);
        appendChange(new CategoriaCreada(categoriaId, gama, procesador, capacidad, tamaño)).apply();
    }

        public void crearOperador(OperadorId operadorId, TipoServicio tipoServicio, ValorPlan valorPlan, NombreOperador nombreOperador){
        Objects.requireNonNull(operadorId);
        Objects.requireNonNull(tipoServicio);
        Objects.requireNonNull(valorPlan);
        Objects.requireNonNull(nombreOperador);
        appendChange(new OperadorCreado(operadorId, tipoServicio, valorPlan, nombreOperador)).apply();
    }

    public void actualizarNombreCelular(CelularId celularId, NombreCelular nombreCelular){
        Objects.requireNonNull(celularId);
        Objects.requireNonNull(nombreCelular);
        appendChange(new NombreCelularActualizado(celularId, nombreCelular)).apply();
    }

    public void calcularPrecioCelular(CelularId celularId, Precio precio, MarcaId marcaId,Gama gama, Procesador procesador, Descuento descuento){
        Objects.requireNonNull(celularId);
        Objects.requireNonNull(precio);
        Objects.requireNonNull(marcaId);
        Objects.requireNonNull(gama);
        Objects.requireNonNull(procesador);
        Objects.requireNonNull(descuento);
        appendChange(new PrecioCelularCalculado(celularId, precio, marcaId, gama, procesador, descuento)).apply();
    }

    public void actualizarNombreMarca(MarcaId marcaId, NombreMarca nombreMarca){
        Objects.requireNonNull(marcaId);
        Objects.requireNonNull(nombreMarca);
        appendChange(new NombreMarcaActualizado(marcaId, nombreMarca)).apply();
    }

    public void actualizarGama(CategoriaId categoriaId, Gama gama, ReceiverId receiverId){
        Objects.requireNonNull(categoriaId);
        Objects.requireNonNull(gama);

        appendChange(new GamaActualizada(categoriaId, gama, receiverId)).apply();
    }

    public void actualizarCapacidad(CategoriaId categoriaId, Capacidad capacidad){
        Objects.requireNonNull(categoriaId);
        Objects.requireNonNull(capacidad);
        appendChange(new CapacidadActualizada(categoriaId, capacidad)).apply();
    }

    public void actualizarProcesador(CategoriaId categoriaId, Procesador procesador, ReceiverId receiverId){
        Objects.requireNonNull(categoriaId);
        Objects.requireNonNull(procesador);
        appendChange(new ProcesadorActualizado(categoriaId, procesador, receiverId)).apply();
    }

    public void calcularDescuento(MarcaId marcaId, NombreMarca nombreMarca, Descuento descuento){
        Objects.requireNonNull(marcaId);
        Objects.requireNonNull(nombreMarca);
        Objects.requireNonNull(descuento);
        appendChange(new DescuentoCalculado(marcaId, nombreMarca, descuento)).apply();
    }

/*    public void actualizarTamaño(CategoriaId categoriaId, Tamaño tamaño){
        Objects.requireNonNull(categoriaId);
        Objects.requireNonNull(tamaño);
        appendChange(new TamañoActualizado(categoriaId, tamaño)).apply();
    }*/

/*    public void actualizarNombreOperador(OperadorId operadorId, NombreOperador nombreOperador){
        Objects.requireNonNull(operadorId);
        Objects.requireNonNull(nombreOperador);
        appendChange(new NombreOperadorActualizado(operadorId, nombreOperador)).apply();
    }*/

/*    public void actualizarTipoServicio(OperadorId operadorId, TipoServicio tipoServicio){
        Objects.requireNonNull(operadorId);
        Objects.requireNonNull(tipoServicio);
        appendChange(new TipoServicioActualizado(operadorId, tipoServicio)).apply();
    }*/

/*
    public void definirValorPlan(OperadorId operadorId, TipoServicio tipoServicio, ValorPlan valorPlan, Gama gama){
        Objects.requireNonNull(operadorId);
        Objects.requireNonNull(tipoServicio);
        Objects.requireNonNull(valorPlan);
        Objects.requireNonNull(gama);
        appendChange(new ValorPlanDefinido(operadorId, tipoServicio, valorPlan, gama)).apply();
    }
*/

    public Marca marcaPorId(MarcaId marcaId){
        return marcas.stream().filter(valor ->valor.identity().equals(marcaId)).findFirst().orElseThrow();
    }

    public Categoria categoriaPorId(CategoriaId categoriaId){
        return categorias.stream().filter(valor ->valor.identity().equals(categoriaId)).findFirst().orElseThrow();
    }

    public NombreCelular nombreCelular() {
        return nombreCelular;
    }

    public Precio precio() {
        return precio;
    }
}
