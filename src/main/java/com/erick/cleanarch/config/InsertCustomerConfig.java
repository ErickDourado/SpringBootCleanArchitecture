package com.erick.cleanarch.config;

import com.erick.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.erick.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.erick.cleanarch.dataprovider.InsertCustomerImpl;
import com.erick.cleanarch.dataprovider.SendCpfForValidationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(FindAddressByZipCodeImpl findAddressByZipCode,
                                                           InsertCustomerImpl insertCustomer,
                                                           SendCpfForValidationImpl sendCpfForValidation) {
        return new InsertCustomerUseCaseImpl(findAddressByZipCode, insertCustomer, sendCpfForValidation);
    }

}
