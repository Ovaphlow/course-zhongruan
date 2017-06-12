package com.zhongruan.monkey.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

  Logger logger = LoggerFactory.getLogger(IndexController.class);

  @RequestMapping(value="/index", method=RequestMethod.GET)
  public String index(Model model) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("msg", "111");
    map.put("status", "12312313");
    List<Map> list = new ArrayList<Map>();
    list.add(map);
    Map<String, Object> map1 = new HashMap<String, Object>();
    map1.put("msg", "13dads");
    map1.put("status", "asde24r0ijf");
    list.add(map1);
    System.out.println(list);
    model.addAttribute("list", list);
    return "index";
  }

  @PostMapping("/login")
  public String loginPost(
    @RequestParam(value="account", defaultValue="") String account,
    @RequestParam(value="password", defaultValue="") String password
  ) {
    logger.info("account: {}", account);
    logger.info("password: {}", password);
    return "redirect:/index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/register")
  public String registerPost(
    @RequestParam(value="password2", defaultValue="") String password2
  ) {
    if (!password2.equals("test")) {
      return "redirect:/register?error=INCONSISTENT_PASSWORD";
    }
    return "redirect:/login";
  }

  @GetMapping("/register")
  public String register() {
    return "register";
  }
}
