package co.com.sofka.ddd.usecase.celular;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.ddd.domain.celular.events.GamaActualizada;
import co.com.sofka.ddd.domain.celular.values.CategoriaId;
import co.com.sofka.ddd.domain.celular.values.Gama;
import co.com.sofka.ddd.domain.celular.values.ReceiverId;
import co.com.sofka.ddd.usecase.celular.evento.NotificarCambioGamaUseCase;
import co.com.sofka.ddd.usecase.celular.evento.ReceiverService;
import co.com.sofka.ddd.usecase.celular.evento.SenderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class NotificarCambioGamaUseCaseTest {

    private NotificarCambioGamaUseCase notificarCambioGamaUseCase;

    private ReceiverService receiverService;
    private SenderService senderService;

    @BeforeEach
    public void setup(){
        notificarCambioGamaUseCase = new NotificarCambioGamaUseCase();
        receiverService = mock(ReceiverService.class);
        senderService = mock(SenderService.class);

        ServiceBuilder builder = new ServiceBuilder()
                .addService(receiverService)
                .addService(senderService);
        notificarCambioGamaUseCase.addServiceBuilder(builder);
    }

    @Test
    void sendMailHappyPath() {
        var event = new GamaActualizada(
                CategoriaId.of("zzz"),
                new Gama("Media"),
                ReceiverId.of("aaa")
        );

        when(receiverService.getEmailReceiverById(any())).thenReturn("almacen@celulares.com");
        doNothing().when(senderService).sendEmail(anyString(), anyString());


        var response = UseCaseHandler.getInstance()
                .syncExecutor(
                        notificarCambioGamaUseCase,
                        new TriggeredEvent<>(event));

        verify(receiverService).getEmailReceiverById(any());
        verify(senderService).sendEmail(anyString(), anyString());


    }
}
