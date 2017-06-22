package com.zhongruan.monkey2.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

  Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
  private SessionFactory sessionFactory;

  @GetMapping("/")
  public String index(Model model) {

    return "index";
  }

  @PostMapping("/login")
  // public String loginPost(UserEntity user) {
  public String loginPost(
      @RequestParam(value="account", defaultValue="") String account,
      @RequestParam(value="password", defaultValue="") String password) {
    logger.info("account: {}", account);
    logger.info("password: {}", password);
    String sql = "select id, name, account, password "
      + "from user "
      + "where account = :account "
      + "and password = :password "
      + "limit 1";
    Session session = sessionFactory.openSession();
    // List<Object[]> _users = session.createSQLQuery(sql)
    List<Map<String, Object>> result = session.createSQLQuery(sql)
      .setParameter("account", account)
      .setParameter("password", password)
      .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
      // .addEntity(User.class)
      .list();
    session.close();
    logger.info("query result: {}", result);
    logger.info("count: {}", result.size());
    if (result.size() == 0) {
      return "redirect:/login";
    }
    logger.debug("{}", result.get(0));
    // for (Object[] _user: _users) {
    //   logger.info("id : {}", _user[0]);
    //   logger.info("name: {}", _user[1]);
    // }
    return "redirect:/";
  }
}
