package com.zhongruan.bizcard.controller;

import java.util.HashMap;
import java.util.Map;

import com.zhongruan.bizcard.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.zhongruan.bizcard.entity.UserEntity;

@Controller
public class UserController {

  private final Logger logger = LoggerFactory.getLogger(UserController.class);

  // 声明SqlSession，从MyBatis类中获取SqlSession工厂的openSession方法的结果
  // MyBatis是util包中的MyBatis框架的初始化类
  // SqlSessionFactory是SqlSession的工厂类，用来生成SqlSession
  // SqlSession是MyBatis框架操作数据库的基本对象
  // SqlSession session = MyBatis.getSessionFactory().openSession();
  // 首先实例化UserDao
  // 通过反射的机制来绑定userDao和user的Mapper文件
  // userDao是接口，user的Mapper是userDao接口的实现
//  UserDao userDao = session.getMapper(UserDao.class);

  // 把UserService注入到当前类中
  @Autowired
  UserService userService;

  @GetMapping("/test")
  // 直接把return的内容返回给客户端，不通过视图层处理
  @ResponseBody
  public Map<String, String> test() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("message", "OK");
    // return的数据类型为map、类或list等的时候，数据会由SpringMVC交给Jackson处理，
    // 并转换为json或json数组的形式，返回给客户端
    return result;
  }

  @PostMapping("/check")
  @ResponseBody
  public Map<String, String> check(
    @RequestParam(value = "account", defaultValue = "") String account
  ) {
    // logger.info("{}", account);
    Map<String, String> result = new HashMap<String, String>();
    if (account.equals("test")) {
      result.put("message", "OK");
    } else {
      result.put("message", "ERROR");
    }
    return result;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  @ResponseBody
  public String registerPost(UserEntity user) {
    logger.info("{}", user);
    return "OK";
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String register() {
    return "register";
  }

  // @PostMapping("login")
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public Map<String, String> loginPost(
    @RequestParam(value = "username", defaultValue = "") String user,
    @RequestParam(value = "password", defaultValue = "") String password
  ) {
    logger.info("user:{}, password:{}", user, password);
    // 声明一个名为result的Map，用来存放查询结果
    // 调用userDao的login方法，把账号和密码的数据传入login的Mapper部分
    // 结果集写入result里
    Map<String, Object> result = userService.login(user, password);
    Map<String, String> map = new HashMap();
    logger.info("{}", result);
    // 判断counter的数量，如果不等于一，说明没有相符的账号或者数据异常
    if (!"1".equals(result.get("counter").toString())) {
      // 数据出错，重定向到登录的url
      map.put("message", "ERROR");
      return map;
    }
    map.put("message", "OK");
    // 把id的内容保存到Session、Cookie或返回token
    // redirect: 代表跳转到如下页面
    return map;
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  // @GetMapping("login")
  public String login(Model model) {
    return "login";
  }
}
