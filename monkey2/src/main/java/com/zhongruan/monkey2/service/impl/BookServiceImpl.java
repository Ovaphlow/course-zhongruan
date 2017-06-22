package com.zhongruan.monkey2.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhongruan.monkey2.dao.BookDao;
import com.zhongruan.monkey2.entity.BookEntity;
import com.zhongruan.monkey2.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

  @Autowired
  private BookDao bookDao;

  @Override
  public List<Map<String, Object>> index() {
    return bookDao.list();
  }

  @Override
  public List<Map<String, Object>> search(String keyword) {
    return bookDao.search(keyword);
  }

  public void append(BookEntity book) {
    bookDao.append(book);
  }
}
