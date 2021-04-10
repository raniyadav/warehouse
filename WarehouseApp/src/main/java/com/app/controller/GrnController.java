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

import com.app.model.Grn;
import com.app.model.GrnDtl;
import com.app.service.IGrnService;
import com.app.service.IPurchaseService;
import com.app.util.CommonUtil;
import com.app.util.GrnUtil;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Controller
@RequestMapping("/grn")
public class GrnController {
	@Autowired
	private IGrnService service;
	@Autowired
	private IPurchaseService purchaseService;
	@Autowired
	private GrnUtil util; 

	private void addChildUi(ModelMap map) {
		/**DropDown for Purchase-start*/
		List<Object[]> plist=purchaseService.getPurchaseIdAndCode();
		Map<Integer,String> purchase=CommonUtil.convertData(plist);
		map.addAttribute("pobs",purchase);
		/**end*/
	}
	
	@RequestMapping("/register")
	public String regGrn(ModelMap map) {
		map.addAttribute("grn",new Grn());
		addChildUi(map);
		return "GrnRegister";
	}

	@RequestMapping(
			value = "/save",
			method = POST
			)
	public String saveGrn(@ModelAttribute Grn grn, ModelMap map) {
		Integer id=service.saveGrn(grn);
		util.saveGrnDtls(grn);
		map.addAttribute("message","Grn created with Id:"+id);
		map.addAttribute("grn",new Grn()) ;
		//change Purchase Status
		purchaseService.updateStatusById(grn.getPurchase().getId(),"RECEIVED");
		//copyGrnDtlsFromPurchseDtls
		addChildUi(map);
		return "GrnRegister";
	}

	@RequestMapping(
			value = "/update",
			method = POST
			)
	public String updateGrn(@ModelAttribute Grn grn, ModelMap map) {
		service.updateGrn(grn);
		map.addAttribute("message","Grn updated");
		List<Grn> list=service.getAllGrns();
		map.addAttribute("list",list);
		addChildUi(map);
		return "GrnData";
	}

	@RequestMapping("/delete")
	public String deleteGrn(@RequestParam Integer id, ModelMap map) {
		service.deleteGrn(id);
		map.addAttribute("message","Grn deleted with Id:"+id);
		List<Grn> list=service.getAllGrns();
		map.addAttribute("list",list);
		return "GrnData";
	}

	@RequestMapping("/edit")
	public String editGrn(@RequestParam Integer id, ModelMap map) {
		Grn ob=service.getOneGrn(id);
		map.addAttribute("grn",ob);
		addChildUi(map);
		return "GrnEdit";
	}

	@RequestMapping("/all")
	public String getAllGrns(ModelMap map) {
		List<Grn> list=service.getAllGrns();
		map.addAttribute("list",list);
		return "GrnData";
	}
	
	/****Childs Screen#2***/
	@RequestMapping("/parts")
	public String showParts(
			@RequestParam Integer id,
			ModelMap map) 
	{
		//get Grn Childs
		List<GrnDtl> childs=service.getGrnDtlByGrnId(id);
		map.addAttribute("childs",childs);
		return "GrnParts";
	}
	
	
	
	
	
	
	
	
}
