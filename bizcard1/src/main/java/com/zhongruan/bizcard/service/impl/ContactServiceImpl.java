package com.zhongruan.bizcard.service.impl;

import com.zhongruan.bizcard.dao.ContactDao;
import com.zhongruan.bizcard.entity.ContactEntity;
import com.zhongruan.bizcard.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

  @Autowired
  ContactDao contactDao;

  @Override
  public List<ContactEntity> findByName(String name) {
    return contactDao.findByName(name);
  }

  @Override
  public List<ContactEntity> findAll() {
    return contactDao.findAll();
  }
}
