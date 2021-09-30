package co.com.sofka.ddd.domain.almacen.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.values.CelularId;
import co.com.sofka.ddd.domain.celular.values.NombreCelular;
import co.com.sofka.ddd.domain.celular.values.Precio;
import co.com.sofka.ddd.domain.celular.values.ReceiverId;

public class CelularAgregado extends DomainEvent {

    private final CelularId celularId;
    private final NombreCelular nombreCelular;
    private final Precio precio;
    private final ReceiverId receiverId;

    public CelularAgregado(CelularId celularId, NombreCelular nombreCelular, Precio precio, ReceiverId receiverId) {
        super("sofka.almace.celularcreado");
        this.celularId = celularId;
        this.nombreCelular = nombreCelular;
        this.precio = precio;
        this.receiverId = receiverId;
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
