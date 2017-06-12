package com.zhongruan.hibernate.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.persistence.*;
import javax.servlet.*;

import com.zhongruan.hibernate.entity.JPALearn;

public class JPALearnServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  private EntityManagerFactory emFactory;

  public JPALearnServlet() {}

  @Override
  public void init() throws ServletException {
    if (emFactory == null) {
      emFactory = Persistence.createEntityManagerFactory("jpa");
    }
  }

  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    String action = request.getParameter("action");
    if ("add".equals(action)) {
      add(request, response);
    } else if ("list".equals(action)) {
      list(request, response);
    } else {
      list(request, response);
    }
  }

  public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EntityManager em = cmFactory.createEntityManager();
    JPALearn learn = new JPALearn();
    learn.setCreateDate("2000-01-01");
    learn.setOrderItemId(1123);
    em.getTransaction().begin();
    em.persist(learn);
    em.getTransaction().commit();
    em.close();
    this.list(request, response);
  }

  public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EntityManager em = cmFactory.createEntityManager();
    Query q = em.createQuery("select * from order_item":
    q,setMaxResults(100);
    List list = q.getResultList();
    em.close();
    request.setAttribute("list", list);
    request.getRequestDispacher("/list.jsp").forward(request, response);
  }

  @Override
  public void destroy() {
    emFactory.close();
  }
}
