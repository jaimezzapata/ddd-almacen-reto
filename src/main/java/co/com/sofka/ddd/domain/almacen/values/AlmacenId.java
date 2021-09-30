package co.com.sofka.ddd.domain.almacen.values;

import co.com.sofka.domain.generic.Identity;

public class AlmacenId extends Identity {

    public AlmacenId() {
    }

    private AlmacenId(String id){
        super(id);
    }

    public static AlmacenId of(String id){
        return new AlmacenId((id));
    }
}
