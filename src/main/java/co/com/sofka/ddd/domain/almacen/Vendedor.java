package co.com.sofka.ddd.domain.almacen;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.ddd.domain.almacen.values.NombreVendedor;
import co.com.sofka.ddd.domain.almacen.values.VendedorId;

public class Vendedor extends Entity<VendedorId> {

    protected final NombreVendedor nombreVendedor;

    public Vendedor(VendedorId entityId, NombreVendedor nombreVendedor) {
        super(entityId);
        this.nombreVendedor = nombreVendedor;
    }
}
