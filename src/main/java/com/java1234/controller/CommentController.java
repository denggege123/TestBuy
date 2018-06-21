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

import com.java1234.entity.Comment;
import com.java1234.entity.PageBean;
import com.java1234.service.CommentService;
import com.java1234.util.NavUtil;
import com.java1234.util.PageUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Resource
	private CommentService commentService;
	
	private String pageCode;
	private String navCode;
	
	@RequestMapping("/getCommentList")
	public ModelAndView getCommentList(String page,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		Map paramMap = new HashMap();
		//设置页面参数
		if(page == null || "".equals(page)){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),10); 
		paramMap.put("start", pageBean.getStart());
		paramMap.put("pageSize", pageBean.getPageSize());
		List<Comment> commentList = commentService.getCommentList(paramMap);
		long count = commentService.getCommentCount();
		pageCode = PageUtil.genPagination("comment/getCommentList.do", count, pageBean.getPage(), pageBean.getPageSize(), "",request);
		
		mav.addObject("pageCode", pageCode);
		mav.addObject("navCode",NavUtil.genNavCode("留言", request));
		mav.addObject("commentList", commentList);
		mav.setViewName("comment");
		return mav;
	}
	
	@RequestMapping("/saveComment")
	public void saveComment(Comment comment,HttpServletRequest request,HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView();
		Map paramMap = new HashMap();
		//将留言插入到数据库
		commentService.saveComment(comment);
		//重新查询数据
		PageBean pageBean=new PageBean(1,10); 
		paramMap.put("start", 1);
		paramMap.put("pageSize", 10);
		List<Comment> commentList = commentService.getCommentList(paramMap);
		long count = commentService.getCommentCount();
		pageCode = PageUtil.genPagination("comment/getCommentList.do", count, pageBean.getPage(), pageBean.getPageSize(), "",request);
		
		request.getSession().setAttribute("commentList", commentList);
		request.getSession().setAttribute("pageCode", pageCode);
		
		JSONObject result=new JSONObject();
		result.put("success", true);
		response.getWriter().write(result.toString());
	}

	
}
