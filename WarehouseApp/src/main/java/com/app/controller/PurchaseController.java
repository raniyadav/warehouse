package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Purchase;
import com.app.model.PurchaseDtl;
import com.app.service.IPartService;
import com.app.service.IPurchaseService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.util.CommonUtil;
import com.app.util.PurchaseUtil;
import com.app.view.VendorInvocePdfView;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	private IPurchaseService service;
	@Autowired
	private IShipmentTypeService shipmentTypeService;
	@Autowired
	private IWhUserTypeService whUserTypeService;
	@Autowired
	private IPartService partService;
	@Autowired
	private PurchaseUtil util;

	//DropDown codes
	private void addUiComponents(ModelMap map) {
		List<Object[]> obs=shipmentTypeService.getShipmentIdAndCode();
		Map<Integer,String> stobs=CommonUtil.convertData(obs);
		map.addAttribute("stobs",stobs);

		List<Object[]> users=whUserTypeService.getWhUserTypeIdAndCode("Vendor");
		Map<Integer,String> usersMap=CommonUtil.convertData(users);
		map.addAttribute("users",usersMap);

	}

	@RequestMapping("/register")
	public String regPurchase(ModelMap map) {
		map.addAttribute("purchase",new Purchase("OPEN"));
		addUiComponents(map);
		return "PurchaseRegister";
	}


	@RequestMapping(value = "/save",method = POST)
	public String savePurchase(@ModelAttribute Purchase purchase, ModelMap map) {
		Integer id=service.savePurchase(purchase);
		map.addAttribute("message","Purchase created with Id:"+id);
		map.addAttribute("purchase",new Purchase()) ;
		addUiComponents(map);
		return "PurchaseRegister";
	}

	@RequestMapping(value = "/update",method = POST)
	public String updatePurchase(@ModelAttribute Purchase purchase, ModelMap map) {
		service.updatePurchase(purchase);
		map.addAttribute("message","Purchase updated");
		List<Purchase> list=service.getAllPurchases();
		map.addAttribute("list",list);
		return "PurchaseData";
	}

	@RequestMapping("/delete")
	public String deletePurchase(@RequestParam Integer id, ModelMap map) {
		service.deletePurchase(id);
		map.addAttribute("message","Purchase deleted with Id:"+id);
		List<Purchase> list=service.getAllPurchases();
		map.addAttribute("list",list);
		return "PurchaseData";
	}

	@RequestMapping("/edit")
	public String editPurchase(@RequestParam Integer id, ModelMap map) {
		Purchase ob=service.getOnePurchase(id);
		map.addAttribute("purchase",ob);
		addUiComponents(map);
		return "PurchaseEdit";
	}

	@RequestMapping("/all")
	public String getAllPurchases(ModelMap map) {
		List<Purchase> list=service.getAllPurchases();
		map.addAttribute("list",list);
		return "PurchaseData";
	}


	/******************************/
	/*********SCREEN#2************/
	/******************************/
	//1. show Parts Screen
	@RequestMapping("/parts")
	public String showParts(
			@RequestParam Integer id,
			ModelMap map) 
	{

		//0. Get Parent with All Childs-To show as Table
		Purchase po=service.getOnePurchase(id);
		map.addAttribute("parent",po);

		//allocate Slno
		util.allocateSlno(po);
		
		//1.form backing object
		PurchaseDtl purchaseDtl=new PurchaseDtl();
		// Link Child With Parent (PK-FK-ID)
		purchaseDtl.setParent(new Purchase(id));
		map.addAttribute("purchaseDtl",purchaseDtl);

		//2.drop down data
		List<Object[]> parts=partService.getPartIdAndCodes();
		Map<Integer,String> partsMap=CommonUtil.convertData(parts);
		map.addAttribute("parts",partsMap);


		return "PurchaseParts";
	}

	//2. call on add button (PART ADD)
	// /add, POST
	@RequestMapping(value="/add",
			method=RequestMethod.POST)
	public String addPart(
			@ModelAttribute PurchaseDtl purchaseDtl,
			ModelMap map
			) 
	{
		service.savePurchaseDtl(purchaseDtl);
		//On Add chnage status to PICKING
		service.updateStatusById(purchaseDtl.getParent().getId(),"PICKING");
		return "redirect:parts?id="+purchaseDtl.getParent().getId();
	}

	//3. Call on remove Part
	//GET/ remove?id=12&dtlId=15
	@RequestMapping("/remove")
	public String delete(
			@RequestParam Integer id,
			@RequestParam Integer dtlId
			) 
	{
		service.deletePurchaseDtl(dtlId);
		//if order contains zero childs
		if(service.getOnePurchase(id)
				.getChilds().isEmpty()) {
			service.updateStatusById(id,"OPEN");
		}
		return "redirect:parts?id="+id;
	}
	
	//4. Generate Vendor invoce PDF
	//GET /venInvoice?id=25
	@RequestMapping("/venInvoice")
	public ModelAndView generateVI(
			@RequestParam Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new VendorInvocePdfView());
		//send data (Purchase with Dtls)
		Purchase po=service.getOnePurchase(id);
		m.addObject("parent",po);
		return m;
	}
	 
	//  updateStatus?id=__&status___
	//  Page: PurchaseData
	//  Redirect:all
	@RequestMapping("/updateStatus")
	public String updateStatus(
			@RequestParam Integer id, 
			@RequestParam String status 
			) 
	{
		service.updateStatusById(id,status);
		return "redirect:all";
	}
	
	
	

}
