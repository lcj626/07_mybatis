package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.model.SearchCriteria;

import java.util.*;

import static com.ohgiraffers.common.Template.*;

public class Application01 {

    public static void main(String[] args){

        //System.out.println(getSession());

        MenuService menuService = new MenuService();
        //menuService.selectMenuByPrice(5000);

//        menuService.searchMenu(new SearchCriteria("category", "한식"));

        SearchCriteria criteria = new SearchCriteria("menuCode", "1");
//        menuService.searchMenuBySupCategory(criteria);

        //menuService.searchMenuByRandomMenuCode(createRandomMenuCodeList());

       // menuService.searchMenuByCodeOrSearchAll(criteria); //-> 위에 SearchCriteria() 에 값 안 넣으면 전체 출력이 된다

        Map<String, Object> test = new HashMap<>();

        test.put("name", "보리");
        test.put("categoryCode", 5); // <- mapper 에 where 문이 없어서 이것만 치면 오류남
        test.put("orderableStatus", "Y");
        test.put("code", "1");

        //menuService.searchMenuByNameOrCategory(test);

        menuService.modifyMenu(test);


    }

    public static List<Integer> createRandomMenuCodeList(){
        Set<Integer> set = new HashSet<>();
        while(set.size() < 5){ // set size 가 5 보다 작을때까지 실행
            int temp = ((int)(Math.random() * 21)) +1;
            set.add(temp);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

}
