package com.zhongruan.monkey1.dao;

import java.util.Map;

import com.zhongruan.monkey1.entity.UserEntity;

import org.apache.ibatis.annotations.Param;

public interface UserDao {

  Map<String, Object> login(
    @Param("account") String account,
    @Param("password") String password
  );

  UserEntity info(@Param("id") int id);

  Map<String, Object> cha(@Param("account") String account);

  void register(
    @Param("account") String account,
    @Param("password") String password,
    @Param("name") String name
  );
}
