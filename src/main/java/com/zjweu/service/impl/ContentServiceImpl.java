package com.zjweu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjweu.dao.ContentMapper;
import com.zjweu.entity.Content;
import com.zjweu.entity.ContentExample;
import com.zjweu.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private ContentMapper contentMapper;

	@Override
	public boolean insert(Content record) {
		int i = contentMapper.insert(record);
		return i == 1 ? true : false;
	}

	@Override
	public boolean deleteContent(Integer ccid) {
		int i = contentMapper.deleteByPrimaryKey(ccid);
		return i == 1 ? true : false;
	}

	@Override
	public List<Content> selectByExample(ContentExample example) {

		List<Content> list = contentMapper.selectByExample(example);
		return list;

	}

}
