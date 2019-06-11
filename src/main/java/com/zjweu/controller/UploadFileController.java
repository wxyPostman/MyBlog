package com.zjweu.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zjweu.entity.Content;
import com.zjweu.service.ContentService;

@Controller
public class UploadFileController {
	@Autowired
	private ContentService contentService;

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public String upload(MultipartFile file, HttpServletRequest request,
			@RequestParam("userinfo_language") String userinfo_language,
			@RequestParam("textContent") String textContent, @RequestParam("userinfo_title") String userinfo_title) {
		System.out.println(userinfo_language + textContent + userinfo_title);
		Content content = new Content();
		content.setCcid(0);
		content.setTitle(userinfo_title);
		content.setContent(textContent);
		content.setType(userinfo_language);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");// 定义格式，不显示毫秒
		Date date = new Date();
		String time = df.format(date);
		content.setPubdate(time);
		contentService.insert(content);
		String oFileName = file.getOriginalFilename();
		System.out.println("文件名字叫做:" + oFileName);
		String dir = request.getServletContext().getRealPath("/uploads/");
		try {
			InputStream in = file.getInputStream();
			OutputStream out = new FileOutputStream(dir + "/" + oFileName);
			IOUtils.copy(in, out);
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

}
