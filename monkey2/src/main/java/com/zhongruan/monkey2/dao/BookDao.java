package com.zhongruan.monkey2.dao;

import java.util.List;
import java.util.Map;

import com.zhongruan.monkey2.entity.BookEntity;

public interface BookDao {

  public List<Map<String, Object>> list();
}

