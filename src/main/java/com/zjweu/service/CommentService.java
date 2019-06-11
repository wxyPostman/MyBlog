package com.zjweu.service;

import java.util.List;


import com.zjweu.entity.Comment;

import com.zjweu.entity.CommentExample;

public interface CommentService {
	
	boolean insert(Comment record);
	
	List<Comment> selectByExample(CommentExample example);

}
