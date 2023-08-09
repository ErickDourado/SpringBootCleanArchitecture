package com.erick.cleanarch.config;

import com.erick.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.erick.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.erick.cleanarch.dataprovider.InsertCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(FindAddressByZipCodeImpl findAddressByZipCode,
                                                           InsertCustomerImpl insertCustomer) {
        return new InsertCustomerUseCaseImpl(findAddressByZipCode, insertCustomer);
    }

}
