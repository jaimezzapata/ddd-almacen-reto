package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.celular.Celular;
import co.com.sofka.ddd.domain.celular.commands.ActualizarCapacidad;

public class ActualizarCapacidadUseCase extends UseCase<RequestCommand<ActualizarCapacidad>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCapacidad> actualizarCapacidadRequestCommand) {
        var command = actualizarCapacidadRequestCommand.getCommand();
        var celular = Celular.from(command.getCelularId(), retrieveEvents(command.getCelularId().value()));

        celular.actualizarCapacidad(command.getCategoriaId(), command.getCapacidad());

        emit().onResponse(new ResponseEvents(celular.getUncommittedChanges()));
    }
}
