package co.com.sofka.ddd.usecase.almacen;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.almacen.Almacen;
import co.com.sofka.ddd.domain.almacen.commands.CrearAlmacen;

public class CrearAlmacenUseCase extends UseCase<RequestCommand<CrearAlmacen>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearAlmacen> crearAlmacenRequestCommand) {
        var command = crearAlmacenRequestCommand.getCommand();
        var almacen = new Almacen(command.getAlmacenId(), command.getNombreAlmacen());

        emit().onResponse(new ResponseEvents(almacen.getUncommittedChanges()));
    }
}
