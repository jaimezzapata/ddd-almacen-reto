package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.celular.Celular;
import co.com.sofka.ddd.domain.celular.commands.CrearMarca;

public class CrearMarcaUseCase extends UseCase<RequestCommand<CrearMarca>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearMarca> crearMarcaRequestCommand) {
        var command = crearMarcaRequestCommand.getCommand();
        var celular = Celular.from(command.getCelularId(), retrieveEvents(command.getCelularId().value()));
        celular.crearMarca(command.getMarcaId(), command.getNombreMarca(), command.getDescuento());

        emit().onResponse(new ResponseEvents(celular.getUncommittedChanges()));
    }
}
