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

import com.zhongruan.monkey2.service.BookService;

@Controller
@RequestMapping("/librarian")
public class LibrarianController {

  Logger logger = LoggerFactory.getLogger(LibrarianController.class);

	@Autowired
  private SessionFactory sessionFactory;

  @Autowired BookService bookService;

  @RequestMapping(value="", method=RequestMethod.GET)
  public String index(Model model) {
    List<Map<String, Object>> result = bookService.index();
    logger.debug("{}", result);
    model.addAttribute("books", result);
    return "librarian";
  }
}
