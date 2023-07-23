package com.erick.cleanarch.dataprovider.client.mapper;

import com.erick.cleanarch.core.domain.Address;
import com.erick.cleanarch.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
