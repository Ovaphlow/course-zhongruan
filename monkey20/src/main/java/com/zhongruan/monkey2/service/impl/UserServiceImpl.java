package com.zhongruan.monkey2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhongruan.monkey2.dao.UserDao;
import com.zhongruan.monkey2.entity.User;
import com.zhongruan.monkey2.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

  @Autowired
  private UserDao userDao;

  @Override
  public void save(User user) {
    userDao.save(user);
  }

  // @Override
  // public void save() {
  //   User user = new User();
  //   user.setName("test");
  //   userDao.save(user);
  // }

  @Override
  @Transactional(rollbackFor={Exception.class})
  public void saveException() throws Exception {
    User user = new User();
    user.setName("testException");
    userDao.save(user);
    throw new Exception();
  }
}
