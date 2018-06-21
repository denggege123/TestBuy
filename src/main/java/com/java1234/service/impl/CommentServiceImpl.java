package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.CommentDao;
import com.java1234.entity.Comment;
import com.java1234.entity.PageBean;
import com.java1234.service.CommentService;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {

	@Resource CommentDao commentDao;
	
	public List<Comment> findCommentList(Comment s_Comment, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Comment> getCommentList(Map map) {
		return commentDao.getCommentList(map);
	}


	public Long getCommentCount() {
		// TODO Auto-generated method stub
		return commentDao.getCommentCount();
	}

	public void saveComment(Comment comment) {
		commentDao.saveComment(comment);
	}

	public Comment getCommentById(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Comment comment) {
		// TODO Auto-generated method stub

	}

}
