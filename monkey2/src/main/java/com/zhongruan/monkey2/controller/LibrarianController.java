package com.zhongruan.monkey2.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.zhongruan.monkey2.entity.BookEntity;
import com.zhongruan.monkey2.service.BookService;

@Controller
@RequestMapping("/librarian")
public class LibrarianController {

  Logger logger = LoggerFactory.getLogger(LibrarianController.class);

	@Autowired
  private SessionFactory sessionFactory;

  @Autowired BookService bookService;

  @DeleteMapping("/book/{id}")
  @ResponseBody
  public String delete(@PathVariable("id") Long id) {
    logger.debug("{}", id);
    try {
      bookService.delete(id);
      return "OK";
    } catch (Exception e) {
      return "ERROR";
    }
  }

  @RequestMapping(value="/book/{id}", method=RequestMethod.POST)
  @ResponseBody
  public String update(BookEntity book, @PathVariable("id") Long id) {
    logger.debug("id {}", id);
    logger.debug("{}", book);
//    BookEntity b = bookService.findById(id);
//    b.setIntro("123123213213");
//    bookService.update(b);
    try {
      bookService.update(book);
      return "OK";
    } catch (Exception e) {
      e.printStackTrace();
      return "ERROR";
    }
  }

  @RequestMapping(value="/book/{id}", method=RequestMethod.GET)
  public String updatePage(
    @PathVariable("id") Long id,
    Model model
  ) {
    BookEntity book = bookService.findById(id);
    // logger.debug("{}", book);
    model.addAttribute("book", book);
    return "librarian/update";
  }

  @RequestMapping(value="/append", method=RequestMethod.POST)
  @ResponseBody
  public String appendPost(BookEntity book) {
    // logger.debug("{}", book);
    try {
      bookService.append(book);
      return "OK";
    } catch (Exception e) {
      e.printStackTrace();
      return "ERROR";
    }
  }

  @RequestMapping(value="/append", method=RequestMethod.GET)
  public String append() {
    return "librarian/append";
  }

  @RequestMapping(value="", method=RequestMethod.GET)
  public String index(Model model) {
    List<Map<String, Object>> result = bookService.index();
    // logger.debug("{}", result);
    model.addAttribute("books", result);
    return "librarian";
  }

  @RequestMapping(value="/search", method=RequestMethod.POST)
  @ResponseBody
  public List<Map<String, Object>> search(
    @RequestParam(value="keyword", defaultValue="") String keyword
  ) {
    return bookService.search(keyword);
  }
}
