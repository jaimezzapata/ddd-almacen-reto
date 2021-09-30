package co.com.sofka.ddd.domain.celular.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Gama implements ValueObject<String> {

    private final String value;

    public Gama(String value){
            this.value = Objects.requireNonNull(value);
            }


    @Override
    public String value() {
            return value;
    }
}
