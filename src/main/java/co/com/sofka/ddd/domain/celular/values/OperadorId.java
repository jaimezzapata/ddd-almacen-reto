package co.com.sofka.ddd.domain.celular.values;

import co.com.sofka.domain.generic.Identity;

public class OperadorId extends Identity {

    public OperadorId() {

    }

    private OperadorId(String id){
        super(id);
    }

    public static OperadorId of(String id){
        return new OperadorId((id));
    }
}
