package com.java1234.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java1234.entity.Notice;
import com.java1234.service.NoticeService;
import com.java1234.util.NavUtil;
import com.java1234.util.StringUtil;

@Controller
@RequestMapping("/notice")
public class noticeController {
	
	@Resource
	private NoticeService noticeService;
	
	private String navCode;
	
	@RequestMapping("/getNoticeInfoById")
	public ModelAndView getNoticeInfoById(String noticeId,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		Notice notice = new Notice();
		if(StringUtil.isNotEmpty(noticeId)){
			notice = noticeService.getNoticeById(Integer.parseInt(noticeId));
		}
		navCode=NavUtil.genNavCode("最新公告",request);
		mav.addObject("navCode", navCode);
		mav.addObject("notice", notice);
		mav.addObject("mainPage", "notice/noticeDetails.jsp");
		mav.setViewName("noticeMain");
		return mav;
	}

}
