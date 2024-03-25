package com.ohgiraffers.section01;

import com.ohgiraffers.section01.DTO.CategoryDTO;
import com.ohgiraffers.section01.DTO.MenuAndCategory;

import static com.common.Template.*;

public class Application01 {

    public static void main(String[] args) {

       ElementTestService service = new ElementTestService();

       MenuAndCategory menuAndCategory = new MenuAndCategory();

//       menuAndCategory.setName("베이글 햄버거");
//       menuAndCategory.setPrice(1000);
//       menuAndCategory.setOrderableStatus("Y");
//       menuAndCategory.setCategory(new CategoryDTO("신규 카테고리"));


       //service.insertNewMenu(menuAndCategory);

       service.selectResultMapConstructorTest();
       //mybatis-config.xml 에서 mapper 등록 안하면 오류남


//         MenuAndCategory menu = new MenuAndCategory();
//         menu.getCategory().setCode();
//         menu = menuAndCategory 의 heap의 주소값에 접근 <-getCategory  => MenuAndCategory 필드에 접근
//         menu.getCategory() 의 return -> category( type categoryDTO(클래스 자료형)
//         menu 주소값에 있는 getCategory 주소값에 있는 setCode 호출


    }
}
