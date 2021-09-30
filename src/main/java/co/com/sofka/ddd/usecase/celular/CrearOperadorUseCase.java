package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.celular.Celular;
import co.com.sofka.ddd.domain.celular.commands.CrearOperador;

public class CrearOperadorUseCase extends UseCase<RequestCommand<CrearOperador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearOperador> crearOperadorRequestCommand) {
        var command = crearOperadorRequestCommand.getCommand();
        var celular = Celular.from(command.getCelularId(), retrieveEvents(command.getCelularId().value()));
        celular.crearOperador(command.getOperadorId(), command.getTipoServicio(), command.getValorPlan(), command.getNombreOperador());

        emit().onResponse(new ResponseEvents(celular.getUncommittedChanges()));
    }
}
