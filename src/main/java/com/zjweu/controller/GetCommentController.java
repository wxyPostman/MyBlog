package com.zjweu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjweu.entity.Comment;
import com.zjweu.entity.CommentExample;
import com.zjweu.entity.RegisterExample;
import com.zjweu.service.CommentService;
import com.zjweu.service.RegisterService;

@Controller
public class GetCommentController {

	@Autowired
	private CommentService commentService;
	private RegisterService registerService;

	@RequestMapping("getComment")
	@ResponseBody
	public Integer Comment(@RequestParam("html") String commentHtml, @RequestParam("id") Integer getId,
			@RequestParam("username") String username) {
		System.out.println(commentHtml + username);
		Comment comment = new Comment();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = df.format(date);

		comment.setCid(0);
		comment.setContent(commentHtml);
		comment.setTitleId(getId);
		comment.setTitleType(time);
		comment.setUsername(username);
		boolean b = commentService.insert(comment);
		if (b) {
			return 200;
		} else {
			return 400;
		}
	}

	@RequestMapping("findAllComment")
	@ResponseBody
	public List<Comment> FindAllComment(@RequestParam("id") Integer getID) {
		CommentExample example = new CommentExample();
		RegisterExample registerExample = new RegisterExample();
		example.createCriteria().andTitleIdEqualTo(getID);
		List<Comment> list = commentService.selectByExample(example);
		return list;
	}
}
