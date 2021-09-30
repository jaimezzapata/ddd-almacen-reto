package co.com.sofka.ddd.domain.almacen;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.ddd.domain.almacen.events.CelularAgregado;
import co.com.sofka.ddd.domain.celular.Celular;

public class AlmacenChange extends EventChange {
    public AlmacenChange(Almacen almacen) {

        apply((CelularAgregado event) ->{
            var celular = new Celular(
                    event.getCelularId(),
                    event.getNombreCelular(),
                    event.getPrecio()
            );
            almacen.celulares.add(celular);
        });
    }
}
