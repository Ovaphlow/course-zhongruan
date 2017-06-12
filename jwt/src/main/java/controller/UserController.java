package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dao.UserDao;
import service.UserService;

@Controller
public class UserController {

  private final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @GetMapping("/test")
  @ResponseBody
  public List<Map<String, Object>> test() {
    userService.insert("1123", "11231", "112312112");
    logger.info("last insert id {}", userService.lastId());
    List<Map<String, Object>> result = userService.selectAll();
    return result;
  }

  @PostMapping("/login")
  public String loginPost(
      @RequestParam(value="account", defaultValue="") String account,
      @RequestParam(value="password", defaultValue="") String password
  ) {
    System.out.println("账号 " + account);
    password = DigestUtils.md5Hex(password);
    System.out.println("密码 " + password);
    return "redirect:/";
  }

  @GetMapping("/login")
  public String login(Model model) {
    return "login";
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }
}
