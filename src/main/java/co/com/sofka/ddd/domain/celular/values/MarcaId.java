package co.com.sofka.ddd.domain.celular.values;

import co.com.sofka.domain.generic.Identity;

public class MarcaId extends Identity {

    public MarcaId() {

    }

    private MarcaId(String id){
        super(id);
    }

    public static MarcaId of(String id){
        return new MarcaId((id));
    }
}
