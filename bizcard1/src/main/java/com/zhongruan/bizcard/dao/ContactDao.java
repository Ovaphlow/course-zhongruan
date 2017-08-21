package com.zhongruan.bizcard.dao;

import com.zhongruan.bizcard.entity.ContactEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactDao {

  ContactEntity findById();

  List<ContactEntity> findByName(@Param("keyword") String keyword);

  List<ContactEntity> findAll();
}
