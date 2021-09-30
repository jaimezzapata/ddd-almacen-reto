package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.celular.Celular;
import co.com.sofka.ddd.domain.celular.commands.ActualizarNombreCelular;

public class ActualizarNombreCelularUseCase extends UseCase<RequestCommand<ActualizarNombreCelular>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCelular> actualizarNombreCelularRequestCommand) {
        var command = actualizarNombreCelularRequestCommand.getCommand();
        var celular = Celular.from(command.getCelularId(),retrieveEvents(command.getCelularId().value()));

        celular.actualizarNombreCelular(command.getCelularId(), command.getNombreCelular());

        emit().onResponse(new ResponseEvents(celular.getUncommittedChanges()));
    }
}
