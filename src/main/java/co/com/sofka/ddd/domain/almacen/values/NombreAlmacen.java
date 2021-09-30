package co.com.sofka.ddd.domain.almacen.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreAlmacen implements ValueObject<String> {
    private final String value;
    public NombreAlmacen(String value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}

