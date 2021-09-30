package co.com.sofka.ddd.domain.almacen;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.ddd.domain.almacen.values.BodegaId;
import co.com.sofka.ddd.domain.almacen.values.Stock;
import co.com.sofka.ddd.domain.almacen.values.Ubicacion;

public class Bodega extends Entity<BodegaId> {

    protected final BodegaId bodegaId;
    protected final Stock stock;
    protected final Ubicacion ubicacion;

    public Bodega(BodegaId bodegaId, Stock stock, Ubicacion ubicacion) {
        super(bodegaId);
        this.bodegaId = bodegaId;
        this.stock = stock;
        this.ubicacion = ubicacion;
    }

    public BodegaId bodegaId() {
        return bodegaId;
    }

    public Stock stock() {
        return stock;
    }

    public Ubicacion ubicacion() {
        return ubicacion;
    }
}
