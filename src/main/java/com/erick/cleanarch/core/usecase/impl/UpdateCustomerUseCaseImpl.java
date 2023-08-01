package com.erick.cleanarch.core.usecase.impl;

import com.erick.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.erick.cleanarch.core.dataprovider.UpdateCustomer;
import com.erick.cleanarch.core.domain.Address;
import com.erick.cleanarch.core.domain.Customer;
import com.erick.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.erick.cleanarch.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final FindAddressByZipCode findAddressByZipCode;
    private final UpdateCustomer updateCustomer;

    public UpdateCustomerUseCaseImpl(FindCustomerByIdUseCase findCustomerByIdUseCase, FindAddressByZipCode findAddressByZipCode, UpdateCustomer updateCustomer) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.findAddressByZipCode = findAddressByZipCode;
        this.updateCustomer = updateCustomer;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdUseCase.findById(customer.getId());
        Address address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);
        updateCustomer.update(customer);
    }

}
