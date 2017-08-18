package com.zhongruan.bizcard.entity;

public class ContactEntity {

  private int id;
  private String name;
  private String company;
  private String title;
  private String address;
  private String remark;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public String toString() {
    return "ContactEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", company='" + company + '\'' +
        ", title='" + title + '\'' +
        ", address='" + address + '\'' +
        ", remark='" + remark + '\'' +
        '}';
  }
}
