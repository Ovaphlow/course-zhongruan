package com.zhongruan.monkey2.service;

import com.zhongruan.monkey2.entity.UserEntity;

public interface UserService {

  public void save(UserEntity user);

  public void saveException() throws Exception;
}
