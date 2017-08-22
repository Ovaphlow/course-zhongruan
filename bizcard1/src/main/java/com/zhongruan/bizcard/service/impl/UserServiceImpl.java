package com.zhongruan.bizcard.service.impl;

import com.zhongruan.bizcard.dao.UserDao;
import com.zhongruan.bizcard.entity.UserEntity;
import com.zhongruan.bizcard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

//业务层代码
@Service
//该类受事务保护
@Transactional
public class UserServiceImpl implements UserService {

//  注入UserDao到UserServiceImpl类中
  @Autowired
  UserDao userDao;

  public UserEntity findById(int id) {
    return userDao.findById(id);
  }

  public Map<String, Object> login(String account, String password) {
    return userDao.login(account, password);
  }
}
