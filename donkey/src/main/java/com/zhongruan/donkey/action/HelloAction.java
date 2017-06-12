package com.zhongruan.donkey.action;

// import javax.persistence.*;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

import com.zhongruan.donkey.domain.User;

@ParentPackage("struts-default")
// @Namespace("/test")
@Results({@Result(name="error", location="error.jsp")})
@ExceptionMappings({@ExceptionMapping(exception="java.lang.RuntimeException", result="error")})
public class HelloAction extends ActionSupport {

  private static final long serialVersionUID = 2730268055700929183L;

  private String account;
  private String password;

	// private EntityManager entity;

  // @PersistenceUnit
  // private EntityManagerFactory emf;
  // private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

  @Action(value="index", results={@Result(name="success", location="index.jsp")})
  public String index() throws Exception {
    return SUCCESS;
  }

  @Action(value="loginPost", results={@Result(name="success", location="index", type="redirect")})
  public String loginPost() throws Exception {
    System.out.println(String.format("[info] account %s, password %s",
        account, password));
    User user = new User();
    user.setAccount(account);
    user.setPassword(password);
    System.out.println(String.format("[debug] user account %s", user.getAccount()));
    // UserEntity user1 = entity.find(UserEntity.class, 1);
    // entity.persist(user);
    if ("test".equals(account) && "test".equals(password)) {
      return SUCCESS;
    } else {
      return ERROR;
    }
  }

  // @Action("login")
  @Action(value="login", results={@Result(name="success", location="login.jsp")})
  public String login() throws Exception {
    return SUCCESS;
  }

  @Action(value="add", results={@Result(name="success", location="add.jsp")})
  public String add() throws Exception {
    return SUCCESS;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}