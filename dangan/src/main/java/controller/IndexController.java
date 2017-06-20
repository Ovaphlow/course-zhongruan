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

import dao.DangAnDao;

// 控制层
// 注解 @
@Controller
public class IndexController {

  private final Logger logger = LoggerFactory.getLogger(IndexController.class);

  // 注入
  @Autowired
  DangAnDao dangan;

  // @RequestMapping(value="/search", method=RequestMethod.POST)
  @PostMapping("/search")
  @ResponseBody
  public List<Map<String, Object>> search(
    @RequestParam(value="keyword", defaultValue="") String keyword
  ) {
    logger.info("{}", keyword);
    List<Map<String, Object>> list = dangan.search(keyword);
    logger.info("{}", list);
    return list;
  }

  @RequestMapping(value="/", method=RequestMethod.GET)
  public String index(Model model) {
    List<Map<String, Object>> list = dangan.list();
    logger.info("{}", list);
    model.addAttribute("dangan", list);
    return "index";
  }
}