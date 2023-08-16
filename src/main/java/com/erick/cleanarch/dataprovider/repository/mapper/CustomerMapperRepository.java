package com.erick.cleanarch.dataprovider.repository.mapper;

import com.erick.cleanarch.core.domain.Customer;
import com.erick.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapperRepository {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
