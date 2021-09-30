package co.com.sofka.ddd.domain.celular.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ddd.domain.celular.values.*;

public class CrearOperador implements Command {

    private final CelularId celularId;
    private final OperadorId operadorId;
    private final TipoServicio tipoServicio;
    private final ValorPlan valorPlan;
    private final NombreOperador nombreOperador;

    public CrearOperador(CelularId celularId, OperadorId operadorId, TipoServicio tipoServicio, ValorPlan valorPlan, NombreOperador nombreOperador) {
        this.celularId = celularId;
        this.operadorId = operadorId;
        this.tipoServicio = tipoServicio;
        this.valorPlan = valorPlan;
        this.nombreOperador = nombreOperador;
    }

    public CelularId getCelularId() {
        return celularId;
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

