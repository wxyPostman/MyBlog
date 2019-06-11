package com.zjweu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjweu.entity.Content;
import com.zjweu.entity.ContentExample;
import com.zjweu.service.ContentService;

@Controller
public class ReadFileController {

	@Autowired
	private ContentService contentService;

	@RequestMapping(value = "readFile", method = RequestMethod.GET)
	@ResponseBody
	public void ReadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Integer getID)
			throws IOException {
		String fileNameText = null;
		ContentExample example = new ContentExample();
		example.createCriteria().andCcidEqualTo(getID);
		List<Content> list = contentService.selectByExample(example);
		for (Content content : list) {
			fileNameText = content.getTitle();
		}
		ServletOutputStream out = response.getOutputStream();
		FileInputStream ips = new FileInputStream(
				new File("C:\\Develop\\apache-tomcat-8.5.38\\webapps\\postmanblog\\uploads\\" + fileNameText + ".md"));
		int len = 0;
		byte[] buffer = new byte[1024 * 10];
		while ((len = ips.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
	}
}
