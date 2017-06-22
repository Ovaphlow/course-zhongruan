package com.zhongruan.monkey2.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhongruan.monkey2.dao.BookDao;
import com.zhongruan.monkey2.entity.BookEntity;

@Repository
public class BookDaoImpl implements BookDao {

  Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

	@Autowired
  private SessionFactory sessionFactory;

  public List<Map<String, Object>> list() {
    String sql = "select id, isbn, name, former_name, author, translator, "
      + "publisher, publication_date, series, language, pages, format, intro "
      + "from book";
    Session session = sessionFactory.openSession();
    List<Map<String, Object>> result = session.createSQLQuery(sql)
      .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
      .list();
    session.close();
    return result;
  }

  public List<Map<String, Object>> search(String keyword) {
    String sql = "select id, isbn, name, former_name, author, translator, "
      + "publisher, publication_date, series, language, pages, format, intro "
      + "from book "
      + "where locate(:keyword, name) > 0 "
      + "or locate(:keyword, former_name) > 0 "
      + "or locate(:keyword, intro) > 0";
    Session session = sessionFactory.openSession();
    List<Map<String, Object>> result = session.createSQLQuery(sql)
      .setParameter("keyword", keyword)
      .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
      .list();
    session.close();
    return result;
  }

  public void append(BookEntity book) {
    //
  }
}

