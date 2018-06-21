package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.News;

public interface NewsDao {
	public List<News> findNewsList(Map<String,Object> map);

	public News getNewsById(int newsId);
}
