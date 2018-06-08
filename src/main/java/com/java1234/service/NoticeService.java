package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Notice;
import com.java1234.entity.PageBean;

public interface NoticeService {

	public List<Notice> findNoticeList(Map<String, Object> map);
	
	public Notice getNoticeById(int noticeId);
	
	public Long getNoticeCount(Notice s_notice);
	
	public void saveNotice(Notice notice);
	
	public void delete(Notice notice);
}
