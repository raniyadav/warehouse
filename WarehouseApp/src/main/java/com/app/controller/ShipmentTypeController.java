package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;

	@RequestMapping("/register")
	public String regShipmentType(ModelMap map) {
		map.addAttribute("shipmenttype",new ShipmentType());
		return "ShipmentTypeRegister";
	}

	@RequestMapping(
			value = "/save",
			method = POST
			)
	public String saveShipmentType(@ModelAttribute ShipmentType shipmenttype, ModelMap map) {
		Integer id=service.saveShipmentType(shipmenttype);
		map.addAttribute("message","ShipmentType created with Id:"+id);
		map.addAttribute("shipmenttype",new ShipmentType()) ;
		return "ShipmentTypeRegister";
	}

	@RequestMapping(
			value = "/update",
			method = POST
			)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmenttype, ModelMap map) {
		service.updateShipmentType(shipmenttype);
		map.addAttribute("message","ShipmentType updated");
		List<ShipmentType> list=service.getAllShipmentTypes();
		map.addAttribute("list",list);
		return "ShipmentTypeData";
	}

	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam Integer id, ModelMap map) {
		service.deleteShipmentType(id);
		map.addAttribute("message","ShipmentType deleted with Id:"+id);
		List<ShipmentType> list=service.getAllShipmentTypes();
		map.addAttribute("list",list);
		return "ShipmentTypeData";
	}

	@RequestMapping("/edit")
	public String editShipmentType(@RequestParam Integer id, ModelMap map) {
		ShipmentType ob=service.getOneShipmentType(id);
		map.addAttribute("shipmenttype",ob);
		return "ShipmentTypeEdit";
	}

	@RequestMapping("/all")
	public String getAllShipmentTypes(ModelMap map) {
		List<ShipmentType> list=service.getAllShipmentTypes();
		map.addAttribute("list",list);
		return "ShipmentTypeData";
	}
}
