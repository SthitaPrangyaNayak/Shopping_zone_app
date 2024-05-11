package com.org.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.UserDao;
import com.org.dto.Seller;
import com.org.dto.User;



@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@PostMapping("/register_user")
	public ModelAndView registerSeller(@ModelAttribute User user)
	{
		ModelAndView mav= new ModelAndView("user/user_login.jsp");
		userDao.saveAndUpdateUser(user);
		return mav;
		
	}
	
	@PostMapping("/login_user")
	public ModelAndView loginUser(@RequestParam String email, @RequestParam String password, HttpSession session)
	{
		User user= userDao.fetchUserByEmailAndPassword(email, password);
		if(user!=null)
		{
			ModelAndView mav= new ModelAndView("user/user_home.jsp");
			session.setAttribute("userId", user.getId());
			return mav;
		}
		ModelAndView mav= new ModelAndView("user/user_login.jsp");
		mav.addObject("fail", "invalid Credentials");
		return mav;
		
	}
}
