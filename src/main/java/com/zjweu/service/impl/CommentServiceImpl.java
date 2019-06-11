package com.zjweu.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjweu.dao.CommentMapper;
import com.zjweu.entity.Comment;
import com.zjweu.entity.CommentExample;
import com.zjweu.service.CommentService;
@Service
public class CommentServiceImpl  implements CommentService{

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public boolean insert(Comment record) {
		int i = commentMapper.insert(record);

		return i==1?true:false;
	}

	@Override
	public List<Comment> selectByExample(CommentExample example) {
		List<Comment> list = commentMapper.selectByExample(example);
		return list;
	}

}
