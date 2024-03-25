package com.ohgiraffers.section01;

import com.ohgiraffers.section01.DTO.MenuAndCategory;
import com.ohgiraffers.section01.DTO.MenuDTO;
import com.ohgiraffers.section01.DTO.collection.CategoryAndMenuDTO;

import java.util.List;

public interface ElementTestMapper {

    List<String> selectCacheTest();

    //컴퓨터 과학에서 데이터나 값을 미리 복사해놓은 임시 장소를 가리킴
    //캐시 접근 시간에 비해 원래 데이터를 접근하는 시간이 오래 걸리는 경우나,
    // 값을 다시 계산하는 시간을 절약하고 싶은 경우 사용 캐시에 데이터를 미리 복사해놓으면 계산이나 접근 시간 없이 더 빠른 속도로 데이터에 접근 가능


    List<MenuDTO> selectResultMapTest();

    List<MenuDTO> selectResultMapConstructorTest();

    List<MenuAndCategory> selectResultMapAssociation();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();

    List<MenuDTO> selectSqlTest();


    int insertNewCategory(MenuAndCategory menuAndCategory);

    int insertNewMenu(MenuAndCategory menuAndCategory);



}
