package com.zjweu.service;

import java.util.List;

import com.zjweu.entity.Content;
import com.zjweu.entity.ContentExample;

public interface IndexContentService {
	List<Content> selectByExample(ContentExample example);
}
