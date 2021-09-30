package co.com.sofka.ddd.usecase.celular.evento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.ddd.domain.celular.events.ProcesadorActualizado;

public class NotificarCambioProcesadorUseCase extends UseCase<TriggeredEvent<ProcesadorActualizado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ProcesadorActualizado> procesadorActualizadoTriggeredEvent) {
        var event = procesadorActualizadoTriggeredEvent.getDomainEvent();
        var receiverService = getService(ReceiverService.class).orElseThrow();
        var senderService = getService(SenderService.class).orElseThrow();

        var email = receiverService.getEmailReceiverById(event.getReceiverId());
        senderService.sendEmail(email, "Este modelo de celular ha cambiado el procesador");
    }
}
