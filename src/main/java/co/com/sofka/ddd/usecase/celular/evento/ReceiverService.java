package co.com.sofka.ddd.usecase.celular.evento;

import co.com.sofka.ddd.domain.celular.values.ReceiverId;

public interface ReceiverService {

    String getEmailReceiverById(ReceiverId receiverId);
}
