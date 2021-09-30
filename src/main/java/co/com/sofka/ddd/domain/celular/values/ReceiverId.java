package co.com.sofka.ddd.domain.celular.values;

import co.com.sofka.domain.generic.Identity;

public class ReceiverId extends Identity {

    public ReceiverId() {

    }

    private ReceiverId(String id){
        super(id);
    }

    public static ReceiverId of(String id){
        return new ReceiverId((id));
    }
}
