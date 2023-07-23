package com.erick.cleanarch.dataprovider;

import com.erick.cleanarch.core.dataprovider.InsertCustomer;
import com.erick.cleanarch.core.domain.Customer;
import com.erick.cleanarch.dataprovider.repository.CustomerRepository;
import com.erick.cleanarch.dataprovider.repository.entity.CustomerEntity;
import com.erick.cleanarch.dataprovider.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerImpl implements InsertCustomer {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

}
