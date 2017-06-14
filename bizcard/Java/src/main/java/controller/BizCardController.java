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

import dao.BizCardDao;
import entity.BizCardEntity;

@Controller
public class BizCardController{

  private final Logger logger = LoggerFactory.getLogger(BizCardController.class);

  // IOC 注入的内容
  @Autowired
  private BizCardDao dao;

  @RequestMapping(value="/", method=RequestMethod.GET)
  public String index(Model model) {
    List<BizCardEntity> list = dao.list();
    logger.info("{}", list);
    model.addAttribute("list", list);
    return "index";
  }

  @GetMapping("/phone")
  public String indexPhone(Model model) {
    List<Map<String, Object>> list = dao.listWithPhone();
    logger.info("{}", list);
    model.addAttribute("list", list);
    return "indexPhone";
  }

  @GetMapping("/search")
  public String searchPage() {
    return "search";
  }

  @PostMapping("/search")
  @ResponseBody // 将数据直接返回给客户端，不输出页面
  public List<Map<String, Object>> search(
    @RequestParam(value="keyword", defaultValue="") String keyword
  ) {
    logger.info("keyword: {}", keyword);
    System.out.println(keyword);
    List<Map<String, Object>> list = dao.search(keyword);
    logger.info("{}", list);
    return list;
  }
}
