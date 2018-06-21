package com.java1234.dao;

import com.java1234.entity.User;

/**
 * �û�DAO�ӿ�
 */
public interface UserDao {
	
	/**
	 * �����û�
	 * @param user
	 */
	public void saveUser(User user);
	
	/**
	 * �û���¼
	 * @param user
	 * @return
	 */
	public User login(User user);


	public int checkUserName(String userName);
}
