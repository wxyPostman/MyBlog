package com.zjweu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjweu.dao.ImageMapper;
import com.zjweu.entity.Image;
import com.zjweu.service.ImageService;
@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageMapper imageMapper;
	@Override
	public boolean insert(Image record) {
		int i = imageMapper.insert(record);
		return i==1?true:false;
	}

}
