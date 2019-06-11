package com.zjweu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjweu.entity.Content;
import com.zjweu.entity.ContentExample;
import com.zjweu.service.IndexContentService;

@Controller
public class IndexContentController {
	@Autowired
	private IndexContentService indexContentService;

	// 分页查询
	@RequestMapping("indexcontentall")
	@ResponseBody
	public PageInfo<Content> indexcontentAll(Integer pageNo) {
		if (pageNo == null)
			pageNo = 1;
		PageHelper.startPage(pageNo, 3);
		List<Content> list = indexContentService.selectByExample(null);
		PageInfo<Content> pageInfo = new PageInfo<>(list);
		return pageInfo;

	}

	// 搜索
	@RequestMapping("search")
	@ResponseBody
	public List<Content> search(String search) {
		List<Content> list;
		ContentExample example = new ContentExample();
		if (search != "") {
			example.createCriteria().andTitleLike("%" + search + "%");
			list = indexContentService.selectByExample(example);
		} else {
			example.createCriteria().andTitleEqualTo(search);
			list = indexContentService.selectByExample(example);
		}

		return list;
	}

	// 归档
	@RequestMapping("archive")
	@ResponseBody
	public List<Content> archive() {
		List<Content> list = indexContentService.selectByExample(null);
		return list;
	}

	// 前后端随笔
	@RequestMapping("essay")
	@ResponseBody
	public List<Content> essay() {
		List<Content> list = indexContentService.selectByExample(null);
		return list;
	}
}