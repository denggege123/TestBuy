package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.UserDao;
import com.java1234.entity.PageBean;
import com.java1234.entity.User;
import com.java1234.service.UserService;

/**
 * 用户Service实现类
 * @author yuyang
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	/**
	 * 增加用户
	 */
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public boolean existUserWithUserName(String userName) {
		return true;
	}
	
	/**
	 * 用户登录
	 */
	public User login(User user) {
		return userDao.login(user);
	}
	
	public boolean checkUserName(String userName) {
		if(userDao.checkUserName(userName)>0){
			return true;
		}else{
			return false;
		}
	}

	public List<User> findUserList(User s_user, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getUserCount(User s_user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
