package com.erick.cleanarch.core.usecase.impl;

import com.erick.cleanarch.core.dataprovider.DeleteCustomerById;
import com.erick.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import com.erick.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final DeleteCustomerById deleteCustomerById;

    public DeleteCustomerByIdUseCaseImpl(FindCustomerByIdUseCase findCustomerByIdUseCase, DeleteCustomerById deleteCustomerById) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.deleteCustomerById = deleteCustomerById;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdUseCase.findById(id);
        deleteCustomerById.delete(id);
    }

}
