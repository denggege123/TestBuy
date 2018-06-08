package com.java1234.dao;

import com.java1234.entity.User;

/**
 * 用户DAO接口
 */
public interface UserDao {
	
	/**
	 * 保存用户
	 * @param user
	 */
	public void saveUser(User user);
	
	
	public Long count(String userName);
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(User user);
}
