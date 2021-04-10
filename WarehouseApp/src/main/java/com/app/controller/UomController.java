package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private UomUtil util;

	//1. Show Register Page
	@RequestMapping("/register")  
	public String showReg(ModelMap map) {
		//form backing -empty object
		map.addAttribute("uom",new Uom());
		return "UomRegister";
	}
	//2. save data -on click submit
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(
			@ModelAttribute Uom uom,
			ModelMap map) 
	{
		//call service layer
		Integer id=service.saveUom(uom);
		String message="Uom '"+id+"' saved successfully";
		//send message to UI
		map.addAttribute("msg", message);
		//form backing -empty object
		map.addAttribute("uom",new Uom());
		return "UomRegister";
	}
	
	
	//3. Get All records from DB
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		//make service layer call
		List<Uom> uoms=service.getAllUoms();
		
		//send data to UI
		map.addAttribute("list",uoms);
		
		//goto UI
		return "UomData";
	}
	
	
	//4. delete uom by id
	@RequestMapping("/delete")
	public String delete(
			@RequestParam Integer id,
			ModelMap map)
	{
		//call service
		service.deleteUom(id);
		//get new data
		List<Uom> uoms=service.getAllUoms();
		//success msg
		String msg="Deleted '"+id+"' successfully";
		//send to UI
		map.addAttribute("list",uoms);
		map.addAttribute("msg",msg);
		return "UomData"; 
	}
	
	//5. Show Edit Page
	@RequestMapping("/edit")
	public String showEdit(
			@RequestParam Integer id,
			ModelMap map){
		
		Uom u=service.getOneUom(id);
		map.addAttribute("uom",u);
		return "UomEdit";
	}
	
	//6. update data
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(
			@ModelAttribute Uom uom,
			ModelMap map){
		
		//service
		service.updateUom(uom);
		//get all rows
		List<Uom> uoms=service.getAllUoms();
		//send data to UI
		String message="Uom '"+uom.getId()+"' Updated successfully";
		map.addAttribute("msg",message);
		map.addAttribute("list",uoms);
		return "UomData";
	}
	
	
	//7. view one page
	@RequestMapping("/view")
	public String getOne(
			@RequestParam Integer id,
			ModelMap map){
		
		Uom uom=service.getOneUom(id);
		map.addAttribute("ob",uom);
		return "UomView";
	}
	
	//8. Excel View
	@RequestMapping("/excel")
	public ModelAndView exportExcel(
			@RequestParam(required=false) Integer id
			) 
	{
		List<Uom> uoms=null;
		if(id==null) {
			//fetch all rows
			uoms=service.getAllUoms();
		}else {
			Uom u=service.getOneUom(id);
			uoms=Arrays.asList(u);
		}
		
		
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		m.addObject("list",uoms);
		return m;
	}
	
	//9. Export to PDF
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(required=false) Integer id){
		
		List<Uom> uoms=null;
		if(id==null)
			uoms=service.getAllUoms();
		else 
			uoms=Arrays.asList(
					service.getOneUom(id));
		
		//read data from DB
		
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		m.addObject("list",uoms);
		return m;
	}

	//10. generate charts
	@RequestMapping("/charts")
	public String genCharts() {
		List<Object[]> list=service.getUomTypeAndCount();
		String path=context.getRealPath("/");
		util.genPie(path,list);
		util.genBar(path,list);
		return "UomCharts";
	}
	
	
	
	
	@RequestMapping("/exist")
	public @ResponseBody String isModelExist(
			@RequestParam String model
			) 
	{
		String message="";
		boolean flag=service.isUomModelExist(model);
		if(flag) {
			message="Uom Model <b>'"+model+"' already exist</b>";
		}
		return message;
	}
	
	
	
}



