package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parttab")
public class Part {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	private String code;
	private Double wdth;
	private Double len;
	private Double hght;
	
	private Double baseCost;
	private String baseCurr;
	private String note;
	
	/***
	 * 1. Integration
	 */
	@ManyToOne
	@JoinColumn(name="uomIdFk")
	private Uom uom;
	
	@ManyToOne
	@JoinColumn(name="saleIdFk")
	private OrderMethod omSale;
	
	@ManyToOne
	@JoinColumn(name="purIdFk")
	private OrderMethod omPurchase;
	
	
	public Part() {
		super();
	}
	public Part(Integer id) {
		super();
		this.id = id;
	}
	public Part(Integer id, String code, Double wdth, Double len, Double hght, Double baseCost, String baseCurr,
			String note) {
		super();
		this.id = id;
		this.code = code;
		this.wdth = wdth;
		this.len = len;
		this.hght = hght;
		this.baseCost = baseCost;
		this.baseCurr = baseCurr;
		this.note = note;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getWdth() {
		return wdth;
	}
	public void setWdth(Double wdth) {
		this.wdth = wdth;
	}
	public Double getLen() {
		return len;
	}
	public void setLen(Double len) {
		this.len = len;
	}
	public Double getHght() {
		return hght;
	}
	public void setHght(Double hght) {
		this.hght = hght;
	}
	public Double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}
	public String getBaseCurr() {
		return baseCurr;
	}
	public void setBaseCurr(String baseCurr) {
		this.baseCurr = baseCurr;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Uom getUom() {
		return uom;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public OrderMethod getOmSale() {
		return omSale;
	}
	public void setOmSale(OrderMethod omSale) {
		this.omSale = omSale;
	}
	public OrderMethod getOmPurchase() {
		return omPurchase;
	}
	public void setOmPurchase(OrderMethod omPurchase) {
		this.omPurchase = omPurchase;
	}
	@Override
	public String toString() {
		return "Part [id=" + id + ", code=" + code + ", wdth=" + wdth + ", len=" + len + ", hght=" + hght
				+ ", baseCost=" + baseCost + ", baseCurr=" + baseCurr + ", note=" + note + ", uom=" + uom + ", omSale="
				+ omSale + ", omPurchase=" + omPurchase + "]";
	}
	

	
}