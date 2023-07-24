package com.erick.cleanarch.dataprovider;

import com.erick.cleanarch.core.dataprovider.FindCustomerById;
import com.erick.cleanarch.core.domain.Customer;
import com.erick.cleanarch.dataprovider.repository.CustomerRepository;
import com.erick.cleanarch.dataprovider.repository.entity.CustomerEntity;
import com.erick.cleanarch.dataprovider.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FindCustomerByIdImpl implements FindCustomerById {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerMapper.toCustomer(entity));
    }

}
