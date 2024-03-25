package com.ohgiraffers.section01;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.Date;

public class Application01 {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "menu";
    private static String PASSWORD = "menu";


    public static void main(String[] args){

        /*
        * JdbcTransactionFactory : 수동 커밋 상태
        * ManagedTransacionFactory : 오토 커밋 상태
        * ----------------------------------------
        *
        * PooledDataSource : ConnectionPool을 사용함
        * UnPooledDataSource : ConnectionPool을 사용하지 않음
        * */
        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(DRIVER,URL,USER,PASSWORD) // 데이터베이스 사용할 건지 말 건지
        ); // 환경설정 정보를 저장한 객체

        Configuration config = new Configuration(environment); // 위 정보 바탕으로 커넥션 설정 등록

        config.addMapper(Mapper.class); // 매퍼 클래스에 등록

        /*
        * SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할
        * Build() : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연관된 Stream을 매개변수로 전달하면
        *           SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
        * */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);

        /*
        * openSession() : SqlSession 인터페이스 타입의 객체를 반환하는 메소드로 boolean 타입을 인자로 전달
        * - false : Connection 인터페이스 타입 객체로 Dml(update,insert,delete) 수행 후 Auto Commit에 대한 옵션을 false 로 지정(권장)
        * - true : connection 인터페이스 타입의 객체로 Dml 수행 후 auto Commit 에 대한 옵션을 true로 지정
        * */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Date date = mapper.selectSysDate();

        System.out.println(date);

        sqlSession.close();

    }
}
