package com.zhongruan.monkey2.service;

import com.zhongruan.monkey2.entity.User;

public interface UserService {

  public void save(User user);

  public void saveException() throws Exception;
}
