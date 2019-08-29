package com.order.detile.serviceimpl;

import com.order.detile.domain.Address;
import com.order.detile.mapper.AddressMapper;
import com.order.detile.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    @Resource(name = "addressMapper")
    AddressMapper addressMapper;
    @Override
    public List<Address> selectAddressByUid(int uid) {
        return addressMapper.selectAddressByUid(uid);
    }

    public Address selectDefaultAddress(int uid){
        Address address=null;
        List<Address> list=selectAddressByUid(uid);
        if(list==null){
            return  null;
        }else{
            for (Address a:list) {
                if(a.getDefaultid()==1){
                    address=a;
                    break;
                }else{
                    address=a;
                }
            }
        }
        return address;
    }
}
