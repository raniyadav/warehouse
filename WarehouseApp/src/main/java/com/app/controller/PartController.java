package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Part;
import com.app.service.IOrderMethodService;
import com.app.service.IPartService;
import com.app.service.IUomService;
import com.app.util.CommonUtil;
@Controller
@RequestMapping("/part")
public class PartController {
	@Autowired
	private IPartService service;
	@Autowired
	private IUomService uomService;
	@Autowired
	private IOrderMethodService omService;


	private void addUiComponents(ModelMap map) {
		List<Object[]> uomlist=uomService.getUomIdAndModels();
		Map<Integer,String> uoms=CommonUtil.convertData(uomlist);
		map.addAttribute("uoms",uoms);

		List<Object[]> omSales=omService.getOrderIdAndCode("Sale");
		Map<Integer,String> omSaleMap=CommonUtil.convertData(omSales);
		map.addAttribute("sales",omSaleMap);
		
		List<Object[]> omPurchase=omService.getOrderIdAndCode("Purchase");
		Map<Integer,String> omPurchaseMap=CommonUtil.convertData(omPurchase);
		map.addAttribute("purchases",omPurchaseMap);
	}

	@RequestMapping("/register")
	public String regPart(ModelMap map) {
		map.addAttribute("part",new Part());

		//child table data
		addUiComponents(map);

		return "PartRegister";
	}

	@RequestMapping(value = "/save",method = POST)
	public String savePart(@ModelAttribute Part part, ModelMap map) {
		Integer id=service.savePart(part) ;
		map.addAttribute("message","Part created with Id:"+id);
		map.addAttribute("part",new Part()) ;
		//child table data
		addUiComponents(map);
		return "PartRegister";
	}

	@RequestMapping(value = "/update",method = POST)
	public String updatePart(@ModelAttribute Part part, ModelMap map) {
		service.updatePart(part);
		map.addAttribute("message","Part updated");
		return "redirect:all";
	}

	@RequestMapping("/delete")
	public String deletePart(@RequestParam Integer id) {
		service.deletePart(id);
		return "redirect:all";
	}

	@RequestMapping("/edit")
	public String editPart(@RequestParam Integer id, ModelMap map) {
		Part ob=service.getOnePart(id);
		map.addAttribute("part",ob);
		//child table data
		addUiComponents(map);
		return "PartEdit";
	}

	@RequestMapping("/all")
	public String getAllParts(ModelMap map) {
		List<Part> parts=service.getAllParts();
		map.addAttribute("list",parts);
		return "PartData";
	}
}
