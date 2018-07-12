package com.sts.inventory.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sts.inventory.service.UserService;

@Controller
public class PageController {
@Autowired
UserService userService;
	@GetMapping("/")
    public String welcome() {
        return "welcome";
    }
//	@GetMapping("/index")
//    public String index() {
//        return "index";
//    }
	
	@GetMapping("/login")
	public  String login() {
		return "login";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/error")
	public String error() {
		
		return "/login-error";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.GET)
	public String authenticate(Model model, String error, String logout) {
		System.out.println("bcubcuasgcjugcighaicghsaigsa---------------------------------------------------------"+error);
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "index";
    }
	
	@GetMapping( "/404,/error")
	public String accesssDenied() {
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		
	  }
	  return "403";
	}
}
