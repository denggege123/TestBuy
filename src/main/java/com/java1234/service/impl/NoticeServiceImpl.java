package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.NoticeDao;
import com.java1234.entity.Notice;
import com.java1234.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Resource
	private NoticeDao noticeDAO;
	
	public List<Notice> findNoticeList(Map<String, Object> map) {
		return noticeDAO.findNoticeList(map);
	}

	public Notice getNoticeById(int noticeId) {
		return noticeDAO.getNoticeById(noticeId);
	}

	public Long getNoticeCount(Notice s_notice) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveNotice(Notice notice) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Notice notice) {
		// TODO Auto-generated method stub
		
	}

}
