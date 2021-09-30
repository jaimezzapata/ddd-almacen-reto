package co.com.sofka.ddd.domain.almacen.values;

import co.com.sofka.domain.generic.Identity;

public class BodegaId extends Identity {

    public BodegaId() {
    }

    private BodegaId(String id){
        super(id);
    }

    public static BodegaId of(String id){
        return new BodegaId((id));
    }
}
