package com.java1234.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java1234.entity.News;
import com.java1234.service.NewsService;
import com.java1234.util.NavUtil;
import com.java1234.util.StringUtil;

@Controller
@RequestMapping("/news")
public class newsController {
	
	@Resource
	private NewsService newsService;
	private String navCode;
	
	@RequestMapping("/getNewsInfoById")
	public ModelAndView getNewsInfoById(String newsId,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		News news = new News();
		if(StringUtil.isNotEmpty(newsId)){
			news = newsService.getNewsById(Integer.parseInt(newsId));
		}
		navCode=NavUtil.genNavCode("ÐÂÎÅ¶¯Ì¬",request);
		mav.addObject("navCode", navCode);
		mav.addObject("news", news);
		mav.addObject("mainPage", "news/newsDetails.jsp");
		mav.setViewName("newsMain");
		return mav;
	}

	
}
