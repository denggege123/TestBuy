package com.java1234.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java1234.entity.Order;
import com.java1234.entity.User;
import com.java1234.service.OrderService;
import com.java1234.service.UserService;
import com.java1234.util.DateJsonValueProcessor;
import com.java1234.util.NavUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

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
	
	@Resource
	private OrderService orderService;
	
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
		String resultUrl = "";
		User currentUser=userService.login(user);
		
		String sImageCode = (String) request.getSession().getAttribute("sRand");
		if(sImageCode!=null && imageCode!=null && imageCode.equals(sImageCode)){ //验证码输入正确
			if(currentUser==null){	
				request.getSession().setAttribute("user", user);
				mav.addObject("error", "用户名或密码错误！");
				if(user.getStatus()==2){
					resultUrl="admin/login";
				}else{
					resultUrl="login";
				}
			}else{
				request.getSession().setAttribute("currentUser", currentUser);
				if(user.getStatus()==2){
					resultUrl="redirect:/admin/main.jsp";
				}else{
					resultUrl = "redirect:/index.jsp";
				}
				
			}
		} else{ //验证码输入错误
			mav.addObject("error", "验证码输入错误");
		}
		mav.setViewName(resultUrl);
		return mav;
		
	}
	
	/**
	 * 跳转到个人中心页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getUserCenter")
	public ModelAndView getUserCenter(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("mainPage", "userCenter/ucDefault.jsp");
		mav.addObject("navCode", NavUtil.genNavCode("个人中心",request));
		mav.setViewName("userCenter");		
		return mav;
	}
	
	/**
	 * 跳转到个人信息页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getUserInfo")
	public ModelAndView getUserInfo(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("mainPage", "userCenter/userInfo.jsp");		
		mav.setViewName("userCenter");		
		return mav;
	}
	
	/**
	 * 跳转到修改个人信息页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getUpdateUserInfo")
	public ModelAndView getUpdateUserInfo(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		User user = (User) request.getSession().getAttribute("currentUser");
		mav.addObject("user",user);
		mav.addObject("mainPage", "userCenter/userSave.jsp");		
		mav.setViewName("userCenter");		
		return mav;
	}
	
	@RequestMapping("/updateUserInfo")
	public ModelAndView getUpdateUserInfo(User user,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();		
		userService.saveUser(user);
		request.getSession().setAttribute("currentUser", user);
		mav.addObject("currentUser", user);
		mav.addObject("mainPage", "userCenter/userInfo.jsp");	
		mav.setViewName("userCenter");
		return mav;
	}
	
	/**
	 * 跳转到个人订单页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getOrderInfo")
	public ModelAndView getOrderInfo(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();	

		User user = (User) request.getSession().getAttribute("currentUser");
		Map map = new HashMap();
		map.put("userId", user.getId());
		//获取订单信息
		List<Order> orderList = orderService.getOrderByUserIdAndOrderNo(map);
		mav.addObject("orderList", orderList);
		mav.addObject("mainPage", "userCenter/orderList.jsp");		
		mav.setViewName("userCenter");		
		return mav;
	}
	
	/**
	 * 注册新的用户信息
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(User user,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();		
		userService.saveUser(user);
		mav.setViewName("login");
		return mav;
	}
	
	/**
	 * 检查用户名称是否存在
	 * @param UserName
	 * @throws IOException 
	 */
	@RequestMapping("/checkUserName")
	public void checkUserName(String UserName,HttpServletRequest request,HttpServletResponse response) throws IOException{
		boolean exist = false;
		exist = userService.checkUserName(UserName);
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("exist", exist);
		response.getWriter().write(jsonResult.toString());
	}
	
	/**
	 * 点击注销按钮，销毁session，跳转到登录页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		//销毁原先的session
		request.getSession().invalidate();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping("/admin/getUserList")
	public void getUserList(String page,String rows,HttpServletRequest request,HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView();
		Map paramMap = new HashMap();
		if(page==null || rows==null){
			page="1";
			rows="10";
		}
		paramMap.put("page", Integer.parseInt(page));
		paramMap.put("pageSize", Integer.parseInt(rows));
		List<User> userList = userService.getUserList(paramMap);
		long total = userService.getUserCount();
		
		JsonConfig jsonConfig = new JsonConfig();    
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);    
		jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
		JSONArray json = JSONArray.fromObject(userList.toArray(),jsonConfig);
		
		JSONObject resultJson = new JSONObject();
		resultJson.put("rows", json);
		resultJson.put("total",total);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(resultJson.toString());
	}
	
	@RequestMapping("/admin/updateUserInfo")
	public void UpdateUserInfo(User user,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json = new JSONObject();
		if(user.getId()==0) {
			json.put("success", false);
		} else{
			userService.saveUser(user);
			json.put("success", true);
		}
		response.getWriter().write(json.toString());
		
	}
	
	
}
