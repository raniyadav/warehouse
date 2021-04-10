package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Controller
@RequestMapping("/om")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	
	//1. Show Register page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}

	//2. on click submit save data
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveOrder(
			@ModelAttribute OrderMethod orderMethod,
			ModelMap map) {
		//service
		Integer id=service.saveOrderMethod(orderMethod);
		String msg="Order '"+id+"' saved successfully";
		map.addAttribute("message",msg);
		map.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}
	
}





