package com.zhongruan.monkey2.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
  private static final long serialVersionUID = 1724315528421427938L;

  @Id
  // @GeneratedValue(strategy=GenerationType.IDENTITY)
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id", nullable=false)
  private Long id;

  @Column(name="account", nullable=false, length=50)
  private String account;

  @Column(name="password", nullable=false, length=50)
  private String password;

  @Column(name="name", nullable=false, length=50)
  private String name;

  @Override
  public String toString() {
    return String.format("User {id: %s, account: %s, password: %s, name: %s",
        id, account, password, name);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}