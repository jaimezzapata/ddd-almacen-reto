package co.com.sofka.ddd.domain.celular.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ddd.domain.celular.values.CategoriaId;
import co.com.sofka.ddd.domain.celular.values.CelularId;
import co.com.sofka.ddd.domain.celular.values.Procesador;
import co.com.sofka.ddd.domain.celular.values.ReceiverId;

public class ActualizarProcesador implements Command {

    private final CelularId celularId;
    private final CategoriaId categoriaId;
    private final Procesador procesador;
    private final ReceiverId receiverId;

    public ActualizarProcesador(CelularId celularId, CategoriaId categoriaId, Procesador procesador,ReceiverId receiverId) {
        this.celularId = celularId;
        this.categoriaId = categoriaId;
        this.procesador = procesador;
        this.receiverId = receiverId;
    }

    public CelularId getCelularId() {
        return celularId;
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
