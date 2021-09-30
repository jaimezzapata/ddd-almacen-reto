package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.ddd.domain.celular.events.ProcesadorActualizado;
import co.com.sofka.ddd.domain.celular.values.CategoriaId;
import co.com.sofka.ddd.domain.celular.values.Procesador;
import co.com.sofka.ddd.domain.celular.values.ReceiverId;
import co.com.sofka.ddd.usecase.celular.evento.NotificarCambioProcesadorUseCase;
import co.com.sofka.ddd.usecase.celular.evento.ReceiverService;
import co.com.sofka.ddd.usecase.celular.evento.SenderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class NotificarCambioProcesadorUseCaseTest {

    private NotificarCambioProcesadorUseCase notificarCambioProcesadorUseCase;

    private ReceiverService receiverService;
    private SenderService senderService;

    @BeforeEach
    public void setup(){
        notificarCambioProcesadorUseCase = new NotificarCambioProcesadorUseCase();
        receiverService = mock(ReceiverService.class);
        senderService = mock(SenderService.class);

        ServiceBuilder builder = new ServiceBuilder()
                .addService(receiverService)
                .addService(senderService);
        notificarCambioProcesadorUseCase.addServiceBuilder(builder);
    }

    @Test
    void sendMailHappyPath() {
        var event = new ProcesadorActualizado(
                CategoriaId.of("zzz"),
                new Procesador("A1"),
                ReceiverId.of("aaa")
        );

        when(receiverService.getEmailReceiverById(any())).thenReturn("almacen@celulares.com");
        doNothing().when(senderService).sendEmail(anyString(), anyString());


        var response = UseCaseHandler.getInstance()
                .syncExecutor(
                        notificarCambioProcesadorUseCase,
                        new TriggeredEvent<>(event));

        verify(receiverService).getEmailReceiverById(any());
        verify(senderService).sendEmail(anyString(), anyString());


    }
}
