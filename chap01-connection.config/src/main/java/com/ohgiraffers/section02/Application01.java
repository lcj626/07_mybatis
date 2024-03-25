package com.ohgiraffers.section02;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Application01 {

    public static void main(String[] args){
        String resource = "mybatis-config.xml";
        SqlSession session = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource); // resource에 있는  "mybatis-config.xml" 파일을 갖고 온다.
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession(false);

            // mapper 에서 java.util로 되어 있음
            Date date = session.selectOne("mapper.selectSysdate"); //mapper ->namespace on mapper.xml
            System.out.println(date + "section02 Application");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            session.close();
        }
    }
}
