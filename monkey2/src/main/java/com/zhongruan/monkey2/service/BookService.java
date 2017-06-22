package com.zhongruan.monkey2.service;

import java.util.List;
import java.util.Map;

import com.zhongruan.monkey2.entity.BookEntity;

public interface BookService {

  public List<Map<String, Object>> index();

  public List<Map<String, Object>> search(String keyword);

  public void append(BookEntity book);
}
