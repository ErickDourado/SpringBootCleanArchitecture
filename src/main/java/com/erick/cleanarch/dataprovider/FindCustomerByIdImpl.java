package com.erick.cleanarch.dataprovider;

import com.erick.cleanarch.core.dataprovider.FindCustomerById;
import com.erick.cleanarch.core.domain.Customer;
import com.erick.cleanarch.dataprovider.repository.CustomerRepository;
import com.erick.cleanarch.dataprovider.repository.entity.CustomerEntity;
import com.erick.cleanarch.dataprovider.repository.mapper.CustomerMapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdImpl implements FindCustomerById {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapperRepository customerMapper;

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerMapper.toCustomer(entity));
    }

}
