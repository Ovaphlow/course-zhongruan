package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 控制层
// 注解 @
@Controller
public class IndexController{

  private final Logger logger = LoggerFactory.getLogger(IndexController.class);

  @RequestMapping(value="/", method=RequestMethod.GET)
  public String index() {
    return "index";
  }
}