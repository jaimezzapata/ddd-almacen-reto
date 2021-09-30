package co.com.sofka.ddd.domain.celular.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ddd.domain.celular.values.NombreOperador;
import co.com.sofka.ddd.domain.celular.values.OperadorId;
import co.com.sofka.ddd.domain.celular.values.TipoServicio;
import co.com.sofka.ddd.domain.celular.values.ValorPlan;

public class OperadorCreado extends DomainEvent {


    private final OperadorId operadorId;
    private final TipoServicio tipoServicio;
    private final ValorPlan valorPlan;
    private final NombreOperador nombreOperador;

    public OperadorCreado(OperadorId operadorId, TipoServicio tipoServicio, ValorPlan valorPlan, NombreOperador nombreOperador) {
        super("sofka.celular.operadorcreado");
        this.operadorId = operadorId;
        this.tipoServicio = tipoServicio;
        this.valorPlan = valorPlan;
        this.nombreOperador = nombreOperador;
    }

    public OperadorId getOperadorId() {
        return operadorId;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public ValorPlan getValorPlan() {
        return valorPlan;
    }

    public NombreOperador getNombreOperador() {
        return nombreOperador;
    }
}
