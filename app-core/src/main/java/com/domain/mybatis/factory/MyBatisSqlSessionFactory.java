package com.domain.mybatis.factory;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.cdi.SessionFactoryProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@ApplicationScoped
public class MyBatisSqlSessionFactory {

  @Produces
  @ApplicationScoped
  @SessionFactoryProvider
  public static SqlSessionFactory produceFactory() {

      SqlSessionFactory sqlSessionFactory = null;
      try {
          String resource = "config/mybatis-config.xml";
          InputStream inputStream = Resources.getResourceAsStream(resource);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      } catch (IOException e) {
          log.info( " Session building info : " + e.getMessage());
      }
    return sqlSessionFactory;
   }

}
