package com.erick.cleanarch.core.usecase;

import com.erick.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {

    Customer findById(final String id);

}
