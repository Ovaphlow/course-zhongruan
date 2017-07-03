package com.zhongruan.monkey2.dao;

import java.util.List;
import java.util.Map;

import com.zhongruan.monkey2.entity.BookEntity;

public interface BookDao {

  void delete(Long id);

  void update(BookEntity book);

  BookEntity findById(Long id);

  void append(BookEntity book);

  List<Map<String, Object>> list();

  List<Map<String, Object>> search(String keyword);
}

