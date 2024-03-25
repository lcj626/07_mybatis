package com.ohgiraffers.section03.remix.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section02.javaconfig.service.MenuService;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final PrintResult printResult;

    private final MenuService menuService;


    public MenuController() {
        this.printResult = new PrintResult();
        this.menuService = new MenuService();
    }

    public void selectAllMenu(){
        List<MenuDTO> menuList = menuService.selectAllMenu();
        if(menuList != null){
            printResult.printMenuList(menuList);
        }else{
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectMenuByCode(Map<String, String> parameter){
        int code = Integer.parseInt(parameter.get("code"));
        MenuDTO menu = menuService.selectByMenuCode(code);

        if(menu != null){
            printResult.printMenu(menu);
        }else{
            printResult.printErrorMessage("SelectOne");
        }
    }

    public void registMenu(Map<String, String> parameter){ //매개변수 이름 파라미터
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int category = Integer.parseInt(parameter.get("category"));

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setCategoryCode(category);
        menu.setPrice(price); //값들 다 꺼내서 dto에 넣음

        if(menuService.registMenu(menu)){ //if 조건절 안에는 boolean 타입만 존재한다.
            printResult.printSuccessMessage("insert");
        }else {
            printResult.printErrorMessage("insert");
        }
    }


    public void modifyMenu(Map<String, String> parameter){
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("category"));
        String status = parameter.get("status");

        MenuDTO menu = new MenuDTO(code, name, price, categoryCode, status);

        if(menuService.modifyMenu(menu)){
            printResult.printSuccessMessage("update");
        }else{
            printResult.printErrorMessage("update");
        }
    }



    public void deleteMenu(int code){



        if(menuService.deleteMenu(code)){
            printResult.printSuccessMessage("delete");
        }else{
            printResult.printErrorMessage("SelectOne");
        }
    }

}
