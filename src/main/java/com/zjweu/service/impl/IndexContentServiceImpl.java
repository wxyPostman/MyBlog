package com.zjweu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjweu.dao.ContentMapper;
import com.zjweu.entity.Content;
import com.zjweu.entity.ContentExample;
import com.zjweu.service.IndexContentService;

@Service
public class IndexContentServiceImpl implements IndexContentService {
	@Autowired
	private ContentMapper contentMapper;

	public List<Content> selectByExample(ContentExample example) {
		List<Content> list = contentMapper.selectByExample(example);
		return list;
	}

}
