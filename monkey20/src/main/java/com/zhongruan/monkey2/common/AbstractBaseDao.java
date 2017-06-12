package com.zhongruan.monkey2.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseDao<Entity extends Serializable> {

	private Class<Entity> entityClass;

	@Autowired
  private SessionFactory sessionFactory;

  public AbstractBaseDao() {
    try {
      Type genType = getClass().getGenericSuperclass();
      Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
      entityClass =  (Class<Entity>)params[0];
    } catch(Exception e) {
      entityClass = null;
    }
  }

  public Session getSession() {
    return sessionFactory.getCurrentSession();
    // Hibernate4 开始用以下方法
    // return sessionFactory.openSession();
  }

  public Entity findById(Serializable id) {
    return (Entity) getSession().get(entityClass, id);
  }

  public void save(Entity e) {
    getSession().save(e);
  }

  public void delete(Entity e) {
    getSession().delete(e);
  }

  public List<Entity> query(String hql, Object[] args) {
    Query query = getSession().createQuery(hql);
    if(args!=null){
      for (int i = 0; i < args.length; i++) {
        query.setParameter(i, args[i]);
      }
    }
    return query.list();
  }
}
