package co.com.sofka.retoDDD.domain.almacen;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retoDDD.domain.almacen.values.Comision;
import co.com.sofka.retoDDD.domain.almacen.values.NombreVendedor;
import co.com.sofka.retoDDD.domain.almacen.values.VendedorId;

public class Vendedor extends Entity<VendedorId> {

    protected final NombreVendedor nombreVendedor;
    protected final Comision comision;

    public Vendedor(VendedorId entityId, NombreVendedor nombreVendedor, Comision comision) {
        super(entityId);
        this.nombreVendedor = nombreVendedor;
        this.comision = comision;
    }
}
