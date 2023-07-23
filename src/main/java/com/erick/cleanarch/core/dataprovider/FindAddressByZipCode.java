package com.erick.cleanarch.core.dataprovider;

import com.erick.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {

    Address find(final String zipCode);

}
