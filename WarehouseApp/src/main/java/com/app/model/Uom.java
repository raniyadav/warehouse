package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//JPA Annotations
@Entity
@Table(name="uomtab")
public class Uom {
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	@Column(name="utype")
	private String uomType;
	
	@Column(
			name="umodel",
			length=8,
			unique=true,
			nullable=false) 
	private String uomModel;
	
	
	@Column(
			name="descr",
			nullable=false,
			length=50
			)
	private String description;
	
	public Uom() {
		super();
	}
	public Uom(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUomType() {
		return uomType;
	}
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	public String getUomModel() {
		return uomModel;
	}
	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Uom [id=" + id + ", uomType=" + uomType + ", uomModel=" + uomModel + ", description=" + description
				+ "]";
	}
	
	
}
