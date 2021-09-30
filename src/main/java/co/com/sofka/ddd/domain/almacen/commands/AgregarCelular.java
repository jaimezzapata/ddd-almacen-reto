package co.com.sofka.ddd.domain.almacen.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ddd.domain.almacen.values.AlmacenId;
import co.com.sofka.ddd.domain.celular.values.CelularId;
import co.com.sofka.ddd.domain.celular.values.NombreCelular;
import co.com.sofka.ddd.domain.celular.values.Precio;
import co.com.sofka.ddd.domain.celular.values.ReceiverId;

public class AgregarCelular implements Command {

    private final AlmacenId almacenId;
    private final CelularId celularId;
    private final NombreCelular nombreCelular;
    private final Precio precio;
    private final ReceiverId receiverId;

    public AgregarCelular(AlmacenId almacenId, CelularId celularId, NombreCelular nombreCelular, Precio precio, ReceiverId receiverId) {
        this.almacenId = almacenId;
        this.celularId = celularId;
        this.nombreCelular = nombreCelular;
        this.precio = precio;
        this.receiverId = receiverId;
    }

    public AlmacenId getAlmacenId() {
        return almacenId;
    }

    public CelularId getCelularId() {
        return celularId;
    }

    public NombreCelular getNombreCelular() {
        return nombreCelular;
    }

    public Precio getPrecio() {
        return precio;
    }

    public ReceiverId getReceiverId() {
        return receiverId;
    }
}
