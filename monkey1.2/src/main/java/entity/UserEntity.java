package com.zhongruan.monkey1.entity;

public class UserEntity {

  private int id;
  private String account;
  private String password;
  private String name;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
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

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("User[id=%s, account=%s, password=%s, name=%s]",
        id,
        account,
        password,
        name);
  }
}
