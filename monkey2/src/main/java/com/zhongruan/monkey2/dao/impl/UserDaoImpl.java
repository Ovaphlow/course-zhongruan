package com.zhongruan.monkey2.dao.impl;

import org.springframework.stereotype.Repository;

import com.zhongruan.monkey2.common.AbstractBaseDao;
import com.zhongruan.monkey2.dao.UserDao;
import com.zhongruan.monkey2.entity.UserEntity;

@Repository
public class UserDaoImpl extends AbstractBaseDao<UserEntity> implements UserDao{

	@Override
	public void save(UserEntity user) {
		super.save(user);
	}
}
