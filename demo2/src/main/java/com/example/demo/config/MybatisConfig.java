package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * MyBatis 연결을 위한 Config 파일  *  * 모든 Config 파일은 보안에 취약하므로 gitignore를 꼭 합시다.  * 본 프로젝트에서는 코드를 보여주기위해 gitignore에 추가하지 않음.
 */
@Configuration
@MapperScan("com.example.demo.mapper")
public class MybatisConfig {
    //""이걸 바꿔줘야함
    private static final String RDS_ENDPOINT = "spring-sopt.cmnxncxddliv.ap-northeast-2.rds.amazonaws.com";
    private static final int RDS_PORT = 3306;
    private static final String RDS_DATABASE_NAME = "sopt-spring-library";
    private static final String CONNECTION_OPTION = "useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String RDS_USER_NAME = "root";
    private static final String RDS_USER_PASSWORD = "12341234";

    @Bean
    public DataSource getDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl(String.format("jdbc:mysql://%s:%d/%s?%s", RDS_ENDPOINT, RDS_PORT, RDS_DATABASE_NAME, CONNECTION_OPTION));
        dataSource.setUsername(RDS_USER_NAME);
        dataSource.setPassword(RDS_USER_PASSWORD);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setConfiguration(configuration);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sessionFactory.getObject();
    }
}