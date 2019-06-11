package com.zjweu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class LogOut {
	//退出
	@RequestMapping("exit")
	@ResponseBody
	public  int exit(HttpSession session ,HttpServletRequest request,HttpServletResponse response) throws IOException{
		session = request.getSession();
		session.removeAttribute("register");
		session.invalidate();
		//session.setAttribute("register", null);
		//System.out.println(session);
		int msg=0;
		return msg;
	}
}
