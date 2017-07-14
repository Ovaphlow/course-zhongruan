package com.zhongruan.monkey2.service;

import java.util.List;
import java.util.Map;

import com.zhongruan.monkey2.entity.BookEntity;

public interface BookService {

  public void delete(Long id);

  public void update(BookEntity book);

  public BookEntity findById(Long id);

  public void append(BookEntity book);

  public List<Map<String, Object>> index();

  public List<Map<String, Object>> search(String keyword);
}
