package com.zjweu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjweu.dao.BaseInfoMapper;
import com.zjweu.service.BaseInfoService;
@Service
public class BaseInfoServiceImpl implements BaseInfoService{
	@Autowired
	private BaseInfoMapper baseInfoMapper;

}
