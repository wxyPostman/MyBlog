package com.zjweu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zjweu.entity.Admire;
import com.zjweu.service.AdmireService;

@Controller
public class AdmireController {
	@Autowired
	private AdmireService admireService;

	@RequestMapping("all")
	public ModelAndView findaAll() {
		ModelAndView mav = new ModelAndView();
		List<Admire> list = admireService.selectByExample(null);
		mav.setViewName("all");
		mav.addObject("list", list);
		return mav;
	}
}
