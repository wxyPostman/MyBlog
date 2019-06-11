package com.zjweu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zjweu.service.BaseInfoService;

@Controller
public class BaseInfoController {

	@Autowired
	private BaseInfoService baseInfoService;
	
}
