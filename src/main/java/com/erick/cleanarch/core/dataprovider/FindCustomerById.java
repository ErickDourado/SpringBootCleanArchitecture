package com.erick.cleanarch.core.dataprovider;

import com.erick.cleanarch.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {

    Optional<Customer> find(final String id);

}
