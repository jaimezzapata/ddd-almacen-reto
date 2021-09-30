package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.celular.Celular;
import co.com.sofka.ddd.domain.celular.commands.CrearCategoria;

public class CrearCategoriaUseCase  extends UseCase<RequestCommand<CrearCategoria>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCategoria> crearCategoriaRequestCommand) {
        var command = crearCategoriaRequestCommand.getCommand();
        var celular = Celular.from(command.getCelularId(), retrieveEvents(command.getCelularId().value()));

        celular.crearCategoria(command.getCategoriaId(),
                command.getGama(),
                command.getProcesador(),
                command.getCapacidad(),
                command.getTamaño()
                );

        emit().onResponse(new ResponseEvents(celular.getUncommittedChanges()));
    }
}
