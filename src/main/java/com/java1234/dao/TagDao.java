package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.News;
import com.java1234.entity.ProductBigType;
import com.java1234.entity.Tag;

public interface TagDao {
	
	public List<Tag> findTagList();
}
