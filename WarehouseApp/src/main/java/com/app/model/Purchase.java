package com.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Entity
@Table(name = "purchasetab")
public  class Purchase {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	private String orderCode;
	private String refNum;
	private String qltyCheck;
	private String status;
	private String note;
	
	/**
	 * Integrations
	 */
	@ManyToOne
	@JoinColumn(name="stIdFk")
	private ShipmentType shipmentType;
	
	@ManyToOne
	@JoinColumn(name="venIdFk")
	private WhUserType vendor;
	
	/**
	 * Bi-Directional
	 */
	@OneToMany(mappedBy="parent",fetch=FetchType.EAGER)
	private List<PurchaseDtl> childs;
	
	
	public Purchase() {
		super();
	}
	public Purchase(Integer id) {
		super();
		this.id = id;
	}
	
	public Purchase(String status) {
		super();
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	public String getQltyCheck() {
		return qltyCheck;
	}
	public void setQltyCheck(String qltyCheck) {
		this.qltyCheck = qltyCheck;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public ShipmentType getShipmentType() {
		return shipmentType;
	}
	public void setShipmentType(ShipmentType shipmentType) {
		this.shipmentType = shipmentType;
	}
	public WhUserType getVendor() {
		return vendor;
	}
	public void setVendor(WhUserType vendor) {
		this.vendor = vendor;
	}
	public List<PurchaseDtl> getChilds() {
		return childs;
	}
	public void setChilds(List<PurchaseDtl> childs) {
		this.childs = childs;
	}
	
	
	

}
