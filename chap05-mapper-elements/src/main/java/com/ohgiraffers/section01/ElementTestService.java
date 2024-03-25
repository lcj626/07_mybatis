package com.ohgiraffers.section01;


import com.ohgiraffers.section01.DTO.MenuAndCategory;
import com.ohgiraffers.section01.DTO.MenuDTO;
import com.ohgiraffers.section01.DTO.collection.CategoryAndMenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.common.Template.*;
public class ElementTestService {

    private ElementTestMapper mapper;

    public void selectCacheTest(){
        SqlSession sqlSession = getSqlSession();
        // getSqlSession 메서드를 이용하여 SqlSession 객체를 가져온다.
        // SqlSession은 MyBatis에서 데이터베이스와의 상호 작용을 담당하는 핵심 객체
        // SqlSession은 SQL 쿼리를 실행하고, 트랜잭션을 제어하며, 매핑된 SQL 쿼리를 호출하는 등의 기능을 수행.
        mapper = sqlSession.getMapper(ElementTestMapper.class);
        // getMapper 메서드는 MyBatis에서 제공하는 메서드로, 매퍼 인터페이스를 구현한 객체를 반환합니다.
        // ElementTestMapper.class는 매퍼 인터페이스를 나타냅니다. 이 인터페이스는 SQL 쿼리를 정의하고, 이를 실행하기 위한 메서드들을 선언합니다.
        // SqlSession 객체인 sqlSession을 사용하여 ElementTestMapper 인터페이스를 구현한 객체를 얻습니다.
        // 이렇게 얻은 mapper 객체는 실제로 매퍼 인터페이스에 정의된 메서드들을 호출하여 SQL 쿼리를 실행할 때 사용됩니다.

        for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();
            List<String> nameList = mapper.selectCacheTest();
            System.out.println(nameList);
            long endTime = System.currentTimeMillis();
            long interval = endTime - startTime;

            System.out.println("수행 시간 : " + interval + "(ms");
        }
        sqlSession.close();
    }


    public void selectResultMapTest(){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapTest();
        for (MenuDTO menu: menuList) {
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectResultMapConstructorTest(){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapConstructorTest();
        for (MenuDTO menu: menuList) {
            System.out.println(menu);
        }
        sqlSession.close();
    }



    public void selectResultMapAssociation(){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuAndCategory> menuList = mapper.selectResultMapAssociation();
        for (MenuAndCategory menu: menuList) {
            System.out.println(menu);
        }
        sqlSession.close();
    }


    public void selectResultMapCollectionTest(){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<CategoryAndMenuDTO> menuList = mapper.selectResultMapCollectionTest();
        for (CategoryAndMenuDTO menu: menuList) {
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectSqlTest(){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectSqlTest();
        for (MenuDTO menu: menuList) {
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void insertNewMenu(MenuAndCategory menu){
        SqlSession session = getSqlSession();
        mapper = session.getMapper(ElementTestMapper.class);

        int resultCateGory = mapper.insertNewCategory(menu);
        int result = mapper.insertNewMenu(menu);

        if(result > 0 && resultCateGory > 0){
            System.out.println("등록 성공");
            session.commit();
        }else{
            System.out.println("등록 실패");
            session.rollback();
        }
        session.close();
    }
}
