package com.erick.cleanarch.dataprovider;

import com.erick.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.erick.cleanarch.core.domain.Address;
import com.erick.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import com.erick.cleanarch.dataprovider.client.mapper.AddressResponseMapper;
import com.erick.cleanarch.dataprovider.client.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }

}
