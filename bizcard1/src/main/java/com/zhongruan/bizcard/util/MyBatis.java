package com.zhongruan.bizcard.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 先有mybatis.xml的配置文件
// 此类为MyBatis的初始化类，工厂类
// 第三步为UserDao接口
// 第四步为UserMapper，作为UserDao接口的实现
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
