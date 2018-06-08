package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.TagDao;
import com.java1234.entity.PageBean;
import com.java1234.entity.Tag;
import com.java1234.service.TagService;

@Service("tagService")
public class TagServiceImpl implements TagService{

	@Resource
	private TagDao tagDAO;
	
	public List<Tag> findTagList() {
		return tagDAO.findTagList();
	}

	public List<Tag> findTagList(Tag s_tag, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getTagCount(Tag s_tag) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveTag(Tag tag) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Tag tag) {
		// TODO Auto-generated method stub
		
	}

	public Tag getTagById(int tagId) {
		// TODO Auto-generated method stub
		return null;
	}

}
