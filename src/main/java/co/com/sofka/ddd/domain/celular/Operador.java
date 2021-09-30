package co.com.sofka.ddd.domain.celular;


import co.com.sofka.domain.generic.Entity;
import co.com.sofka.ddd.domain.celular.values.NombreOperador;
import co.com.sofka.ddd.domain.celular.values.OperadorId;
import co.com.sofka.ddd.domain.celular.values.TipoServicio;
import co.com.sofka.ddd.domain.celular.values.ValorPlan;

public class Operador extends Entity<OperadorId> {

    private final TipoServicio tipoServicio;
    private final ValorPlan valorPlan;
    private final NombreOperador nombreOperador;


    public Operador(OperadorId operadorId, TipoServicio tipoServicio, ValorPlan valorPlan, NombreOperador nombreOperador) {

        super(operadorId);
        this.tipoServicio = tipoServicio;
        this.valorPlan = valorPlan;
        this.nombreOperador = nombreOperador;

    }

    public TipoServicio tipoServicio() {
        return tipoServicio;
    }

    public ValorPlan valorPlan() {
        return valorPlan;
    }

    public NombreOperador nombreOperador() {
        return nombreOperador;
    }
}
