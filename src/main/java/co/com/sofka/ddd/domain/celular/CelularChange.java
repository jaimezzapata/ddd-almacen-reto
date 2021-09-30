package co.com.sofka.ddd.domain.celular;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.ddd.domain.celular.events.*;
import java.util.HashSet;

public class CelularChange extends EventChange {
    public CelularChange(Celular celular) {

        apply((CelularCreado event) -> {
            celular.nombreCelular = event.getNombreCelular();
            celular.precio = event.getPrecio();
            celular.marcas = new HashSet<>();
            celular.categorias = new HashSet<>();
            celular.operadores = new HashSet<>();
        });

        apply((MarcaCreada event) ->{
            var marca = new Marca(
                    event.getMarcaId(),
                    event.getNombreMarca(),
                    event.getDescuento()
            );
            celular.marcas.add(marca);
        });

        apply((CategoriaCreada event) ->{
            var categoria = new Categoria(
                    event.getCategoriaId(),
                    event.getCapacidad(),
                    event.getGama(),
                    event.getProcesador(),
                    event.getTamaño()
            );
            celular.categorias.add(categoria);
        });

        apply((OperadorCreado event) ->{
            var operador = new Operador(
                    event.getOperadorId(),
                    event.getTipoServicio(),
                    event.getValorPlan(),
                    event.getNombreOperador()
            );
            celular.operadores.add(operador);
        });

        apply((NombreMarcaActualizado event) ->{
            celular.marcaPorId(event.getMarcaId()).actualizarNombre(event.getNombreMarca());
        });

        apply((GamaActualizada event) ->{
            celular.categoriaPorId(event.getCategoriaId()).actualizarGama(event.getGama());
        });

        apply((CapacidadActualizada event) ->{
            celular.categoriaPorId(event.getCategoriaId()).actualizarCapacidad(event.getCapacidad());
        });

        apply((ProcesadorActualizado event) ->{
            celular.categoriaPorId(event.getCategoriaId()).actualizarProcesador(event.getProcesador());
        });
    }
}
