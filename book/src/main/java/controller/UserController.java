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

@Controller
public class UserController {

  private final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserDao userDao;

  @RequestMapping(value="/", method=RequestMethod.GET)
  public String index() {
    return "index";
  }

  @RequestMapping(value="/book/{id}", method=RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> book(
    @PathVariable("id") int id
  ) {
    logger.debug("id: {}", id);
    Map<String, Object> result = userDao.findById(id);
    logger.debug("result: {}", result);
    return result;
  }
}
