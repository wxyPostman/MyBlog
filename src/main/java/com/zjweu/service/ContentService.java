package com.zjweu.service;

import java.util.List;

import com.zjweu.entity.Content;
import com.zjweu.entity.ContentExample;

public interface ContentService {
	 boolean insert(Content record);
	
	 boolean deleteContent(Integer ccid);
	 
	 List<Content> selectByExample(ContentExample example);
}
