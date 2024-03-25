package com.ohgiraffers.common;

import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    private static SqlSessionFactory sessionFactory;

    public static SqlSession sqlSession(){
        if(sessionFactory == null){
            try {
                InputStream inputStream = Resources.getResourceAsStream("xmlconfig2/mybatis-config.xml");
                sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return sessionFactory.openSession(false); // 여기서 만든 세션 팩토리로 다른 클래스들에서도 돌려쓴다

    }
}
