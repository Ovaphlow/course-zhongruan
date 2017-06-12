package com.zhongruan.donkey.domain;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id", unique=true, nullable=false)
  private long id;

  @Column(name="account", nullable=false, length=50)
  private String account;

  @Column(name="password", length=50)
  private String password;

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAccount() {
    return this.account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}