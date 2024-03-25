package com.ohgiraffers.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    public static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSession(){
        if(sqlSessionFactory == null){ // 아직 공장을 안만들어 줘서 null
            String resource = "config/mybatis-config.xml"; //"config/mybatis-config.xml" 를 resource에 담음

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                //InputStream은 Java의 입출력 스트림을 읽기 위한 추상 클래스이다.
                // 이 클래스는 바이트 단위로 데이터를 읽을 수 있는 메서드를 제공하며, 입출력 작업에서 사용됨
                // Resources 에서 받아온 resource("config/mybatis-config.xml")를 inputStream으로 읽음

                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // inputStream으로 읽어오는 자료들로 팩토리를 빌드해서 sqlSessionFactory를 생성함
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory.openSession(false);
    }
}
