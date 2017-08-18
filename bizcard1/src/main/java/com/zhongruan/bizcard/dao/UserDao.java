package com.zhongruan.bizcard.dao;

import java.util.Map;

import com.zhongruan.bizcard.entity.UserEntity;

import org.apache.ibatis.annotations.Param;

public interface UserDao {

  // Param注解用来声明参数的名字
  // Param注解里的参数名必须要和Mapper里的#{}参数名一致
  Map<String, Object> login(@Param("account") String account,
      @Param("password") String password);
}
