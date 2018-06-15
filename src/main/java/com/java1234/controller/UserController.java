package com.java1234.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java1234.entity.User;
import com.java1234.service.UserService;

/**
 * 用户Controller层
 * @author yuyang
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	private String userName;
	private User user;
	private String error;
	
	private String imageCode;
	
	private String mainPage;
	private String navCode;
	
	private User s_user;
	
	private String page;
	private String rows;
	
	private String ids;
	
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public User getS_user() {
		return s_user;
	}
	public void setS_user(User s_user) {
		this.s_user = s_user;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getMainPage() {
		return mainPage;
	}
	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}
	public String getNavCode() {
		return navCode;
	}
	public void setNavCode(String navCode) {
		this.navCode = navCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public String getImageCode() {
		return imageCode;
	}
	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(User user,String imageCode,HttpServletRequest request)throws Exception{
		
		ModelAndView mav = new ModelAndView();
		String resultUrl = "login";
		User currentUser=userService.login(user);
		
		String sImageCode = (String) request.getSession().getAttribute("sRand");
		if(sImageCode!=null && imageCode!=null && imageCode.equals(sImageCode)){ //验证码输入正确
			if(currentUser==null){	
				request.getSession().setAttribute("user", user);
				mav.addObject("error", "用户名或密码错误！");
			}else{
				request.getSession().setAttribute("currentUser", currentUser);
				resultUrl = "redirect:/index.jsp";
			}
		} else{ //验证码输入错误
			mav.addObject("error", "验证码输入错误");
		}
		mav.setViewName(resultUrl);
		return mav;
		
		
	}
}
