package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.News;

public interface NewsService {

	public List<News> findNewsList(Map<String, Object> map);
	
	public News getNewsById(int newsId);
	
	public Long getNewsCount(News s_news);
	
	public void saveNews(News news);
	
	public void delete(News news);
}
