package com.java1234.service;

import java.util.List;

import com.java1234.entity.PageBean;
import com.java1234.entity.User;

/**
 * 用户Service接口
 * @author yuyang
 *
 */
public interface UserService {

	/**
	 * 增加用户
	 * @param user
	 */
	public void saveUser(User user);
	
	public boolean existUserWithUserName(String userName);
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	public List<User> findUserList(User s_user,PageBean pageBean);
	
	public Long getUserCount(User s_user);
	
	public void delete(User user);
	
	public User getUserById(int id);

	public boolean checkUserName(String userName);
}
