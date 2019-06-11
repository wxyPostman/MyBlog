package com.zjweu.controller;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjweu.duanxin.Duanxin;
import com.zjweu.entity.Register;
import com.zjweu.entity.RegisterExample;
import com.zjweu.service.RegisterService;

@Controller
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	@RequestMapping("captcha")
	@ResponseBody
	public int ca(String phone) {
		String cap = "";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int t = random.nextInt(10);
			cap += String.valueOf(t);
		}
		Duanxin.sendOne("注册", cap, phone);
		int capt = Integer.parseInt(cap);
		return capt;
	}

	@RequestMapping("reg")
	@ResponseBody
	public String register(Register record) {
		boolean isok = registerService.insert(record);
		String msg;
		if (isok) {
			msg = "注册成功";
		} else {
			msg = "注册失败";
		}
		return msg;
	}

	@RequestMapping("login")
	@ResponseBody
	public int login(String phone, String password, HttpSession session) {
		Register register = registerService.selectByPhone(phone);
		int msg;
		if (register != null) {
			if (register.getPassword().equalsIgnoreCase(password)) {
				register.setPassword("");
				session.setAttribute("register", register);
				msg = 200;
			} else {
				msg = 400;
			}
		} else {
			msg = 500;
		}
		return msg;
	}

	@RequestMapping("check")
	@ResponseBody
	public String check(String username) {
		RegisterExample example = new RegisterExample();
		example.createCriteria().andUsernameEqualTo(username);
		boolean isok = registerService.countByExample(example);
		String msg = "";
		if (isok) {
			msg = "";
		} else {
			msg = "用户名被占用，请更换！";
		}
		return msg;

	}

	@RequestMapping("phone")
	@ResponseBody
	public int phone(String phone) {
		RegisterExample example = new RegisterExample();
		example.createCriteria().andPhoneEqualTo(phone);
		boolean isok = registerService.countByExample(example);
		int msg;
		if (isok) {
			msg = 200;
		} else {
			msg = 400;
		}
		return msg;

	}

	@RequestMapping("exita")
	@ResponseBody
	public Object session(HttpSession session, HttpServletRequest request) {
		session = request.getSession();
		Object reg = session.getAttribute("register");
		System.out.println(reg);
		return reg;
	}

	@RequestMapping("update")
	@ResponseBody
	public int update(Integer id,String username, String phone) {
		Register register = new Register();
		register.setId(id);
		register.setUsername(username);
		register.setPhone(phone);
		boolean isok = registerService.updateByPrimaryKeySelective(register);
		int msg = 0;
		if (isok) {
			msg = 200;
		} else {
			msg = 400;
		}
		return msg;

	}
	
	@RequestMapping("select")
	@ResponseBody
	public Register selectByPhone(String phone){
		Register register = null;
		if(phone!=null){
			register = registerService.selectByPhone(phone);
		}else{
			register = null;
		}
		return register;
		
	}
}
