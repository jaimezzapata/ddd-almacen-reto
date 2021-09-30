package co.com.sofka.ddd.domain.almacen.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreVendedor implements ValueObject<String> {

    private final String value;
    public NombreVendedor(String value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
