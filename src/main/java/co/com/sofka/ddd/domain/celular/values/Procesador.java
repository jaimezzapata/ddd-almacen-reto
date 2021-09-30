package co.com.sofka.ddd.domain.celular.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Procesador implements ValueObject<String> {

    private final String value;

    public Procesador(String value){
        this.value = Objects.requireNonNull(value);
    }


    @Override
    public String value() {
        return value;
    }
}
