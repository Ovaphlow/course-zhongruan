package com.zhongruan.sic.entity;

public class UserEntity {

  private String account;

  public String getAccount() {
    return this.account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  private String password;

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return String.format("UserEntity{account=%s, password=%s}",
        account, password);
  }}
