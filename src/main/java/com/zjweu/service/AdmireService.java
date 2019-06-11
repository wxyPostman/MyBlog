package com.zjweu.service;

import java.util.List;

import com.zjweu.entity.Admire;
import com.zjweu.entity.AdmireExample;

public interface AdmireService {
	 List<Admire> selectByExample(AdmireExample example);
}
