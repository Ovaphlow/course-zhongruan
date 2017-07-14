package com.zhongruan.monkey2.controller;

import java.util.List;

import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.zhongruan.monkey2.entity.User;
import com.zhongruan.monkey2.service.UserService;

@Controller
public class Index {

  Logger logger = LoggerFactory.getLogger(Index.class);

  @Autowired
  private UserService userService;

	@Autowired
  private SessionFactory sessionFactory;

  @GetMapping("/index")
  public String index() {
    return "index";
  }

  @PostMapping("/login")
  public String loginPost(User user) {
    logger.info("account: {}", user.getAccount());
    logger.info("password: {}", user.getPassword());
    logger.info("{}", user);
    user.setName(user.getAccount());
    String sql = "select id, name, account, password "
      + "from user "
      + "where account = :account "
      + "and password = :password "
      + "limit 1";
    Session session = sessionFactory.openSession();
    // List<Object[]> _users = session.createSQLQuery(sql)
    List _users = session.createSQLQuery(sql)
      .setParameter("account", user.getAccount())
      .setParameter("password", user.getPassword())
      .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
      // .addEntity(User.class)
      .list();
      // .list()
    session.close();
    logger.info("query result: {}", _users);
    logger.info("count: {}", _users.size());
    if (_users.size() == 0) {
      return "redirect:/login";
    }
    logger.info(_users.get(0).toString());
    // for (Object[] _user: _users) {
    //   logger.info("id : {}", _user[0]);
    //   logger.info("name: {}", _user[1]);
    // }
    return "redirect:/index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/register")
  public String registerPost(
    @RequestParam(value="password2", defaultValue="") String password2,
    User user
  ) {
    if (!password2.equals(user.getPassword())) {
      return "redirect:/register?error=INCONSISTENT_PASSWORD";
    }
    user.setName(user.getAccount());
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(user);
    session.getTransaction().commit();
    session.close();
    userService.save(user);
    return "redirect:/login";
  }

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @RequestMapping("/save")
  @ResponseBody
  public String save() {
    // userService.save();
    return "Hello World! by save";
  }

  @RequestMapping("/saveException")
  @ResponseBody
  public String saveException() {
    try {
      userService.saveException();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "Hello World! by saveException";
  }
}
