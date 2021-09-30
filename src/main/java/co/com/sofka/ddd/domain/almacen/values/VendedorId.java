package co.com.sofka.ddd.domain.almacen.values;

import co.com.sofka.domain.generic.Identity;

public class VendedorId extends Identity {

    public VendedorId() {
    }

    private VendedorId(String id){
        super(id);
    }

    public static VendedorId of(String id){
        return new VendedorId((id));
    }
}
