package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.celular.Celular;
import co.com.sofka.ddd.domain.celular.commands.ActualizarNombreMarca;

public class ActualizarNombreMarcaUseCase extends UseCase<RequestCommand<ActualizarNombreMarca>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreMarca> actualizarNombreMarcaRequestCommand) {
        var command = actualizarNombreMarcaRequestCommand.getCommand();
        var celular = Celular.from(command.getCelularId(), retrieveEvents(command.getCelularId().value()));

        celular.actualizarNombreMarca(command.getMarcaId(), command.getNombreMarca());

        emit().onResponse(new ResponseEvents(celular.getUncommittedChanges()));
    }
}
