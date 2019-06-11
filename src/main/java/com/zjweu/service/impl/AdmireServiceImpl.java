package com.zjweu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjweu.dao.AdmireMapper;
import com.zjweu.entity.Admire;
import com.zjweu.entity.AdmireExample;
import com.zjweu.service.AdmireService;
@Service
public class AdmireServiceImpl implements AdmireService{
	@Autowired
	private AdmireMapper admireMapper;
	public List<Admire> selectByExample(AdmireExample example) {
		List<Admire> list = admireMapper.selectByExample(example);
		return list;
	}

}
