package com.erick.cleanarch.core.usecase;

import com.erick.cleanarch.core.domain.Customer;

public interface InsertCustomerUseCase {

    void insert(Customer customer, String zipCode);

}
