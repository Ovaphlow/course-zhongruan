package com.zhongruan.bizcard.dao;

import com.zhongruan.bizcard.entity.ContactEntity;

import java.util.List;

public interface ContactDao {

  ContactEntity findById();

  List<ContactEntity> findByName();

  List<ContactEntity> findAll();
}
