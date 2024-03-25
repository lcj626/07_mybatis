package com.ohgiraffers.section03.remix.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section02.javaconfig.model.JavaMenuDAO;
import com.ohgiraffers.section03.remix.model.RemixMenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getRemixSession;

public class MenuService {


    private RemixMenuDAO menuDAO;

    public List<MenuDTO> selectAllMenu(){
        SqlSession session = getRemixSession();

        RemixMenuDAO remixMenuDAO = session.getMapper(RemixMenuDAO.class); // interface에서 구현해 준 dao 클래스를 초기화 시켜줌
        List<MenuDTO> menuList = menuDAO.selectAllMenu(session);

        session.close();

        return menuList;
    }

    public MenuDTO selectByMenuCode(int code) {
        SqlSession session = getRemixSession();

        menuDAO = session.getMapper(RemixMenuDAO.class);
        MenuDTO menu = menuDAO.selectByMenuCode(code);
        session.close();
        return menu;
    }

    public boolean registMenu(MenuDTO menu) {// if 조건절 안에 있어서 자연스럽게 boolean 으로 나옴
        SqlSession session = getRemixSession();

        menuDAO = session.getMapper(RemixMenuDAO.class);
        int result = menuDAO.registMenu(menu);

        if(result >0){
            session.commit();
        }else{
            session.rollback();
        }
        session.close();

        return result > 0? true : false;

    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession session = getRemixSession();

        menuDAO = session.getMapper(RemixMenuDAO.class);
        int result = menuDAO.modifyMenu(session, menu);

        if(result >0){
            session.commit(); // commit 문을 넣지 않으면 반영이 되지 않는다 commit은 close 문 이전에 만들어 줘야 한다 close 이후에는 날아가니까
        }else{
            session.rollback();
        }
        session.close();

        return result > 0? true : false;
    }

    public boolean deleteMenu(int code) {

        SqlSession session = getRemixSession();
        int result = menuDAO.deleteMenu(session, code);

        if(result > 0){
            session.commit();
        }else{
            session.rollback();
        }
        session.close();

        return result > 0? true : false;
    }
}
