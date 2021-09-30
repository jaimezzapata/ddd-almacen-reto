package co.com.sofka.ddd.domain.celular.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.values.CategoriaId;
import co.com.sofka.ddd.domain.celular.values.Procesador;
import co.com.sofka.ddd.domain.celular.values.ReceiverId;

public class ProcesadorActualizado extends DomainEvent {
    private final CategoriaId categoriaId;
    private final Procesador procesador;
    private final ReceiverId receiverId;

    public ProcesadorActualizado(CategoriaId categoriaId, Procesador procesador, ReceiverId receiverId) {
        super("sofka.celular.procesadoractualizado");
        this.categoriaId = categoriaId;
        this.procesador = procesador;
        this.receiverId = receiverId;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public ReceiverId getReceiverId() {
        return receiverId;
    }
}
