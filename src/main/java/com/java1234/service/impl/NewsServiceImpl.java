package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.NewsDao;
import com.java1234.entity.News;
import com.java1234.service.NewsService;

@Service("newsService")
public class NewsServiceImpl implements NewsService{

	@Resource
	private NewsDao newsDao;
	
	
	public List<News> findNewsList(Map<String, Object> map) {
		return newsDao.findNewsList(map);
	}

	public News getNewsById(int newsId) {
		return newsDao.getNewsById(newsId);
	}

	public Long getNewsCount(News s_news) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveNews(News news) {
		// TODO Auto-generated method stub
		
	}

	public void delete(News news) {
		// TODO Auto-generated method stub
		
	}

}
