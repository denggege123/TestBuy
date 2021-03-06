package com.java1234.dao;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(User user);


	public int checkUserName(String userName);

	public List<User> getUserList(Map map);

	public long getUserCount();
}
