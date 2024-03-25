package com.ohgiraffers.common;

import com.ohgiraffers.section01.model.AddressDTO;

import java.util.List;

public class PrintResult {

    public void printAddressList(List<AddressDTO> addressList){
        for (AddressDTO address: addressList) {
            System.out.println(address);
        }
    }

    public void printAddress(AddressDTO addressDTO){
        System.out.println(addressDTO);
    }








}
