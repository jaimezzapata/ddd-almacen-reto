package co.com.sofka.ddd.domain.almacen;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.almacen.events.AlmacenCreado;
import co.com.sofka.ddd.domain.almacen.events.CelularAgregado;
import co.com.sofka.ddd.domain.almacen.values.AlmacenId;
import co.com.sofka.ddd.domain.almacen.values.NombreAlmacen;
import co.com.sofka.ddd.domain.celular.Celular;
import co.com.sofka.ddd.domain.celular.values.CelularId;
import co.com.sofka.ddd.domain.celular.values.NombreCelular;
import co.com.sofka.ddd.domain.celular.values.Precio;
import co.com.sofka.ddd.domain.celular.values.ReceiverId;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Almacen extends AggregateEvent<AlmacenId> {

    protected NombreAlmacen nombreAlmacen;
    protected Set<Bodega> bodegas;
    protected Set<Vendedor> vendedores;
    protected Set<Factura> facturas;
    protected Set<Celular> celulares;

    public Almacen(AlmacenId almacenId, NombreAlmacen nombreAlmacen) {
        super(almacenId);
        appendChange(new AlmacenCreado(nombreAlmacen)).apply();
    }

    public Almacen(AlmacenId almacenId){
        super(almacenId);
        subscribe(new AlmacenChange(this));
    }

    public static Almacen from(AlmacenId almacenId, List<DomainEvent> events){
        var almacen = new Almacen(almacenId);
        events.forEach(almacen::applyEvent);
        return almacen;
    }

    public void AgregarCelular(CelularId celularId, NombreCelular nombreCelular, Precio precio, ReceiverId receiverId){
        Objects.requireNonNull(celularId);
        Objects.requireNonNull(nombreCelular);
        Objects.requireNonNull(precio);
        appendChange(new CelularAgregado(celularId, nombreCelular,precio, receiverId)).apply();
    }


    public NombreAlmacen nombreAlmacen() {
        return nombreAlmacen;
    }
}
