package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.News;
import com.java1234.entity.Notice;

public interface NoticeDao {
	public List<Notice> findNoticeList(Map<String,Object> map);

	public Notice getNoticeById(int noticeId);
}
