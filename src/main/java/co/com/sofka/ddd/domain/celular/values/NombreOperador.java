package co.com.sofka.ddd.domain.celular.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreOperador implements ValueObject<String> {

    private final String value;

    public NombreOperador(String value){
        this.value = Objects.requireNonNull(value);
    }


    @Override
    public String value() {
        return value;
    }
}
