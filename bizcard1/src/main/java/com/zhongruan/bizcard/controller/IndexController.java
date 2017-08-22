package com.zhongruan.bizcard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhongruan.bizcard.entity.UserEntity;
import com.zhongruan.bizcard.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.zhongruan.bizcard.entity.ContactEntity;

//后端程序的调用顺序
//客户端->控制层(controller)->业务层(service)->数据访问接口(dao)->DataBase
//DB->DAO->Service->Controller->Client

//@代表注解
//@Controller代表当前类为SpringMVC框架的控制层代码
@Controller
public class IndexController {

  private final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  ContactService contactService;

  @GetMapping("/list")
  @ResponseBody
  public List<ContactEntity> list() {
    return contactService.findAll();
  }

  // @RequestMapping代表处理参数中value属性的值作为一个暴露给用户的URL
  @RequestMapping(value = "/", method = RequestMethod.GET)
  // @GetMapping("/")
  public String index(@SessionAttribute UserEntity user, Model model) {
    // /WEB-INF/jsp/index.jsp
    logger.info("session: {}", user);
    Map<String, String> map = new HashMap<String, String>();
    map.put("name", "MC");
    map.put("company", "电影院");
    map.put("title", "老板");
    map.put("address", "万达秀园D8 一单元1103");
    map.put("remark", "江北第一黄牛");
    Map<String, String> map1 = new HashMap<String, String>();
    map1.put("name", "大鳄");
    map1.put("company", "电影院");
    map1.put("title", "员工");
    map1.put("address", "荷兰城");
    map1.put("remark", "荷兰城城主");
    Map<String, String> map2 = new HashMap<String, String>();
    map2.put("name", "狗头肃");
    map2.put("company", "宠物店");
    map2.put("title", "宠物");
    map2.put("address", "万达华园C3 43楼");
    map2.put("remark", "肇源床叔");
    model.addAttribute("map", map);
    List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    list.add(map);
    list.add(map1);
    list.add(map2);
    model.addAttribute("list1", list);
    List<ContactEntity> contactList = contactService.findAll();
    model.addAttribute("list", contactList);
    return "index";
  }

//  @RequestMapping(value = "/", method = RequestMethod.POST)
  @PostMapping("/")
  @ResponseBody
  public List<ContactEntity> indexPost(
      @RequestParam(value = "keyword", defaultValue = "") String keyword) {
    logger.info("{}", keyword);
    List<ContactEntity> contacts = contactService.findByName(keyword);
    logger.info("{}", contacts);
    return contacts;
  }
}
