package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.User;
import com.jt.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<User> userList=userService.findAll();
		model.addAttribute("userList", userList);//将userList集合存入request域中
		return "userList";
		
	}
	//实现ajax页面的跳转
	@RequestMapping("/ajax")
	public String ajax() {
		return "ajax";
	}
	//获取用户列表数据
	@RequestMapping("/ajaxFindUser")
	@ResponseBody   //使返回结果类型变为json类型
	public List<User> ajaxFindUser(Integer id){
		System.out.println("获取用户id:"+id);
		return userService.findAll();
		
	}
}
