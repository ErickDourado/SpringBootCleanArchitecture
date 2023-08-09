package com.erick.cleanarch.config;

import com.erick.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.erick.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import com.erick.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.erick.cleanarch.dataprovider.UpdateCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
                                                           FindAddressByZipCodeImpl findAddressByZipCode,
                                                           UpdateCustomerImpl updateCustomer) {
        return new UpdateCustomerUseCaseImpl(findCustomerByIdUseCase, findAddressByZipCode, updateCustomer);
    }

}
