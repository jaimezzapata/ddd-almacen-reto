package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.celular.Celular;
import co.com.sofka.ddd.domain.celular.commands.ActualizarProcesador;

public class ActualizarProcesadorUseCase extends UseCase<RequestCommand<ActualizarProcesador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarProcesador> actualizarProcesadorRequestCommand) {
        var command = actualizarProcesadorRequestCommand.getCommand();
        var celular = Celular.from(command.getCelularId(), retrieveEvents(command.getCelularId().value()));

        celular.actualizarProcesador(command.getCategoriaId(), command.getProcesador(), command.getReceiverId());

        emit().onResponse(new ResponseEvents(celular.getUncommittedChanges()));
    }
}
