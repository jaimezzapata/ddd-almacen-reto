package co.com.sofka.ddd.domain.celular.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.values.*;

public class GamaActualizada extends DomainEvent {

    private final CategoriaId categoriaId;
    private final ReceiverId receiverId;
    private final Gama gama;


    public GamaActualizada(CategoriaId categoriaId, Gama gama, ReceiverId receiverId) {
        super("sofka.celular.gamadefinida");
        this.categoriaId = categoriaId;
        this.gama = gama;
        this.receiverId = receiverId;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public Gama getGama() {
        return gama;
    }


    public ReceiverId getReceiverId() {
        return receiverId;
    }
}

