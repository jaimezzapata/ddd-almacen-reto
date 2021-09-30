package co.com.sofka.ddd.domain.celular.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ddd.domain.celular.values.CategoriaId;
import co.com.sofka.ddd.domain.celular.values.CelularId;
import co.com.sofka.ddd.domain.celular.values.Gama;
import co.com.sofka.ddd.domain.celular.values.ReceiverId;

public class ActualizarGama implements Command {

    private final CelularId celularId;
    private final CategoriaId categoriaId;
    private final Gama gama;
    private final ReceiverId receiverId;

    public ActualizarGama(CelularId celularId, CategoriaId categoriaId, Gama gama, ReceiverId receiverId) {
        this.celularId = celularId;
        this.categoriaId = categoriaId;
        this.gama = gama;
        this.receiverId = receiverId;
    }

    public CelularId getCelularId() {
        return celularId;
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
