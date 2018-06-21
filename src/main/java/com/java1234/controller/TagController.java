package com.java1234.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java1234.entity.Tag;
import com.java1234.service.TagService;

@Controller
@RequestMapping("/tag")
public class TagController {
	
	@Resource
	private TagService tagService;
	
	private String pageCode;
	private String navCode;
	
	@RequestMapping("/getTagList")
	public String getTagList(HttpServletRequest request,HttpServletResponse response){
		
		List<Tag> tagList=tagService.findTagList();
		request.getSession().setAttribute("smallTypeList", tagList);
		
		return "redirect:/index.jsp";
	}

}
