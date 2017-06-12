package com.zhongruan.monkey1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.zhongruan.monkey1.dao.UserDao;
import com.zhongruan.monkey1.entity.UserEntity;
import com.zhongruan.monkey1.util.MyBatis;

@Controller
public class IndexController {

  Logger logger = LoggerFactory.getLogger(IndexController.class);

  SqlSession session = MyBatis.getSessionFactory().openSession();
  UserDao userDao = session.getMapper(UserDao.class);

  @RequestMapping(value="/", method=RequestMethod.GET)
  public String index(Model model) {
    UserEntity user = userDao.info(1);
    logger.info("{}", user);
    model.addAttribute("user", user);
    return "index";
  }

  @PostMapping("/login")
  public String loginPost(
    @RequestParam(value="account", defaultValue="") String account,
    @RequestParam(value="password", defaultValue="") String password
  ) {
    logger.info("account: {}", account);
    logger.info("password: {}", password);
    Map<String, Object> result = userDao.login(account, password);
    logger.info("result: {}", result);
    return "redirect:/";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/register")
  public String registerPost(UserEntity user) {
    logger.info("{}", user);
    userDao.register(user);
    session.commit();
    return "redirect:/register";
  }

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @GetMapping("/checkUser")
  @ResponseBody
  public Map<String, String> checkUser(
    @RequestParam(value="account", defaultValue="") String account
  ) {
    logger.info("{}", account);
    Map<String, String> result = new HashMap<String, String>();
    result.put("message", "OK");
    return result;
  }
}
