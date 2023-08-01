package com.erick.cleanarch.core.usecase;

import com.erick.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {

    void update(Customer customer, String zipCode);

}
