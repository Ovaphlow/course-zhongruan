package com.zhongruan.bizcard.service;

import com.zhongruan.bizcard.entity.ContactEntity;

import java.util.List;

public interface ContactService {

  List<ContactEntity> findByName(String name);

  List<ContactEntity> findAll();
}