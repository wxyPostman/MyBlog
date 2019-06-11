package com.zjweu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zjweu.entity.Comment;
import com.zjweu.entity.Content;
import com.zjweu.entity.ContentExample;
import com.zjweu.entity.Register;
import com.zjweu.service.CommentService;
import com.zjweu.service.ContentService;
import com.zjweu.service.RegisterService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private RegisterService registerService;
	@Autowired
	private ContentService contentService;
	@RequestMapping("save")
	@ResponseBody
	public int save(String content,String username1,String name,String title){
		ContentExample contentExample=new ContentExample();
		int rid=0;
		int id=0;
		int titleid=0;
		int msg=0;
		List<Register>list = registerService.selectByExample(null);
		for(Register register:list){
			if(register.getUsername().equals(username1)){
				rid=register.getId();
			}
			if(register.getUsername().equals(name)){
				id=register.getId();
			}
		}
		contentExample.createCriteria().andTitleEqualTo(title);
		List<Content> list2 = contentService.selectByExample(contentExample);
		for(Content content2:list2){
			titleid=content2.getCcid();
		}
		Comment comment=new Comment();
		comment.setCid(0);
		comment.setContent(content);
		comment.setTitleId(titleid);
		comment.setFormId(rid);
		comment.setId(id);
		boolean isok = commentService.insert(comment);
		if(isok){
			msg=200;
			System.out.println(200);
		}else{
			msg=400;
		}
		return msg;
	}
	
	@RequestMapping("findall")
	@ResponseBody
	public List<Comment> findall(){
		List<Comment> list = commentService.selectByExample(null);
		return list;
	}

}
