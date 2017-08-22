package com.zhongruan.bizcard.service;

import com.zhongruan.bizcard.entity.UserEntity;

import java.util.Map;

//UserService接口
public interface UserService {

  UserEntity findById(int id);

  Map<String, Object> login(String account, String password);
}
