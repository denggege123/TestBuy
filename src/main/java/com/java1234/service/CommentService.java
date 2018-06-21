package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Comment;
import com.java1234.entity.PageBean;

public interface CommentService {

	public List<Comment> findCommentList(Comment s_Comment,PageBean pageBean);
	
	public Long getCommentCount();
	
	public void saveComment(Comment comment);
	
	public Comment getCommentById(int commentId);
	
	public void delete(Comment comment);

	public List<Comment> getCommentList(Map map);
}
