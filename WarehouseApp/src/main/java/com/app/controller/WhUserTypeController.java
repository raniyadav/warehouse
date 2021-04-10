package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.util.EmailUtil;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private EmailUtil emailUtil;

	@RequestMapping("/register")
	public String regWhUserType(ModelMap map) {
		map.addAttribute("whusertype",new WhUserType());
		return "WhUserTypeRegister";
	}

	@RequestMapping(
			value = "/save",
			method = POST
			)
	public String saveWhUserType(
			@ModelAttribute WhUserType whusertype,
			@RequestParam CommonsMultipartFile fileDoc,
			ModelMap map) {
		
		Integer id=service.saveWhUserType(whusertype);
		map.addAttribute("whusertype",new WhUserType()) ;
		String msg="User created with Id:"+id;
		
		
		
		if(id!=null) { //on saved successfully send email
			String text=" Hello: "+whusertype.getCode()
			+", You are :"+whusertype.getUserType()
			+" , You can have :"+whusertype.getUserFor();
			
			boolean isSent=emailUtil.send(
					whusertype.getUserEmail(),
					"Welcome to Warehouse App",
					text,
					fileDoc.getSize()!=0?
							fileDoc:null);
			
			if(isSent) msg+=", Email also sent";
			else  msg+=",Email sending Failed";
		}
		
		
		map.addAttribute("message",msg);
		
		return "WhUserTypeRegister";
	}

	@RequestMapping(
			value = "/update",
			method = POST
			)
	public String updateWhUserType(@ModelAttribute WhUserType whusertype, ModelMap map) {
		service.updateWhUserType(whusertype);
		map.addAttribute("message","WhUserType updated");
		List<WhUserType> list=service.getAllWhUserTypes();
		map.addAttribute("list",list);
		return "WhUserTypeData";
	}

	@RequestMapping("/delete")
	public String deleteWhUserType(@RequestParam Integer id, ModelMap map) {
		service.deleteWhUserType(id);
		map.addAttribute("message","WhUserType deleted with Id:"+id);
		List<WhUserType> list=service.getAllWhUserTypes();
		map.addAttribute("list",list);
		return "WhUserTypeData";
	}

	@RequestMapping("/edit")
	public String editWhUserType(@RequestParam Integer id, ModelMap map) {
		WhUserType ob=service.getOneWhUserType(id);
		map.addAttribute("whusertype",ob);
		return "WhUserTypeEdit";
	}

	@RequestMapping("/all")
	public String getAllWhUserTypes(ModelMap map) {
		List<WhUserType> list=service.getAllWhUserTypes();
		map.addAttribute("list",list);
		return "WhUserTypeData";
	}
}
