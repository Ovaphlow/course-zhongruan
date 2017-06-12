package com.zhongruan.monkey1.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatis {
  public static SqlSessionFactory getSessionFactory() {
    SqlSessionFactory sessionFactory = null;
    String resource = "mybatis.xml";
    try {
      sessionFactory = new SqlSessionFactoryBuilder().build(
        Resources.getResourceAsReader(resource)
      );
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sessionFactory;
  }
}
