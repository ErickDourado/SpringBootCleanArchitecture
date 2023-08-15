package com.erick.cleanarch.entrypoint.consumer;

import com.erick.cleanarch.core.domain.Customer;
import com.erick.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.erick.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.erick.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "erick")
    public void receive(CustomerMessage customerMessage) {
        Customer customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerUseCase.update(customer, customerMessage.getZipCode());
    }

}
