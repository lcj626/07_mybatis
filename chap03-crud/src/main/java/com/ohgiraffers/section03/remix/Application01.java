package com.ohgiraffers.section03.remix;

import com.ohgiraffers.section02.javaconfig.controller.MenuController;

import java.util.HashMap;
import java.util.Map;

public class Application01 {

    public static void main(String[] args){

        //System.out.println(getSqlSession());

        MenuController menu = new MenuController();

//        Map<String, String> value = new HashMap<>();
//
//        value.put("name", "보리새우 떡볶이");
//        value.put("price", "5000");
//        value.put("category", "5");
//
//        menu.registMenu(value);

        Map<String, String> test = new HashMap<>();
        test.put("code", "100");

        menu.selectMenuByCode(test);

//        menu.selectAllMenu();


    }
}
