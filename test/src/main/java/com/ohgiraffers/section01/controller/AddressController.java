package com.ohgiraffers.section01.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.section01.service.AddressService;

public class AddressController {


    private final PrintResult printResult;

    private final AddressService addressService;


    public AddressController(){
        this.printResult = new PrintResult();
        this.addressService = new AddressService();
    }




}
