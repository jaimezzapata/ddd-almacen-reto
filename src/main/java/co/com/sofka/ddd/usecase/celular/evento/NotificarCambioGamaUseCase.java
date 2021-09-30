package co.com.sofka.ddd.usecase.celular.evento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.ddd.domain.celular.events.GamaActualizada;

public class NotificarCambioGamaUseCase extends UseCase<TriggeredEvent<GamaActualizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<GamaActualizada> gamaActualizadaTriggeredEvent) {
        var event = gamaActualizadaTriggeredEvent.getDomainEvent();
        var receiverService = getService(ReceiverService.class).orElseThrow();
        var senderService = getService(SenderService.class).orElseThrow();

        var email = receiverService.getEmailReceiverById(event.getReceiverId());
        senderService.sendEmail(email, "Se ha cambiado la gama");
    }
}
