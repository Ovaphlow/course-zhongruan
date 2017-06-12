package com.zhongruan.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name="order_item")
public class JPALearn {

  @Id
  @GeneratedValue(strategy = GeneretionType.AUTO)
  private Long id;

  @Column
  private String create_date;

  @Column
  private int order_item_id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCreateDate() {
    return create_id;
  }

  public void setCreateDate(String create_date) {
    this.create_date = create_date;
  }

  public int getOrderItemId() {
    return order_item_id;
  }

  public void setOrderItemId(int order_item_id) {
    this.order_item_id = order_item_id;
  }

  public String toString() {
    return String.format("[INFO] %s, %s, %s", id, create_date, order_item_id);
  }
}
