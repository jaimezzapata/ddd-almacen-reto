package co.com.sofka.ddd.domain.celular.values;

import co.com.sofka.domain.generic.Identity;

public class CelularId extends Identity {

    public CelularId() {

    }

    private CelularId(String id){
        super(id);
    }

    public static CelularId of(String id){
        return new CelularId((id));
    }
}
