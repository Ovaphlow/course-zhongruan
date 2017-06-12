package service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public void insert(String account, String password, String name) {
    userDao.insert(account, password, name);
  }

  @Override
  public int lastId() {
    return userDao.lastId();
  }

  @Override
  public List<Map<String, Object>> selectAll() {
    return userDao.selectAll();
  }
}