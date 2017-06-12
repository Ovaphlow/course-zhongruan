package com.zhongruan.monkey2.dao.impl;

import org.springframework.stereotype.Repository;

import com.zhongruan.monkey2.common.AbstractBaseDao;
import com.zhongruan.monkey2.dao.UserDao;
import com.zhongruan.monkey2.entity.User;

@Repository
public class UserDaoImpl extends AbstractBaseDao<User> implements UserDao{

	@Override
	public void save(User user) {
		super.save(user);
	}
}
