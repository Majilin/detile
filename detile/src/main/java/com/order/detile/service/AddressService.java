package com.order.detile.service;

import com.order.detile.domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> selectAddressByUid(int uid);
    Address selectDefaultAddress(int uid);
}
