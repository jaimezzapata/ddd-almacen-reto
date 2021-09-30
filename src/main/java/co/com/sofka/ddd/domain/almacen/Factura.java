package co.com.sofka.retoDDD.domain.almacen;


import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retoDDD.domain.almacen.values.*;

public class Factura extends Entity<FacturaId> {

    private final NombreVendedor nombreVendedor;
    private final Cantidad cantidad;
    private final ValorTotal valorTotal;
    private final Fecha fecha;

    public Factura(FacturaId entityId, NombreVendedor nombreVendedor, Cantidad cantidad, ValorTotal valorTotal, Fecha fecha ) {
        super(entityId);
        this.nombreVendedor = nombreVendedor;
        this.cantidad = cantidad;
        this.valorTotal = valorTotal;
        this.fecha = fecha;
    }

    public NombreVendedor nombreVendedor() {
        return nombreVendedor;
    }

    public Cantidad cantidad() {
        return cantidad;
    }

    public ValorTotal valorTotal() {
        return valorTotal;
    }

    public Fecha fecha() {
        return fecha;
    }
}
