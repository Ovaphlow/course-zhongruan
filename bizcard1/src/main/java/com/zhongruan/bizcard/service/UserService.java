package com.zhongruan.bizcard.service;

import java.util.Map;

//UserService接口
public interface UserService {

  Map<String, Object> login(String account, String password);
}
