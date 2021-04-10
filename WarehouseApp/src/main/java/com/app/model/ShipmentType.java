package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Entity
@Table(name = "shipmenttypetab")
public final class ShipmentType {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	private String mode;
	private String code;
	private String enableShp;
	private String grade;
	private String note;
	public ShipmentType() {
		super();
	}
	public ShipmentType(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEnableShp() {
		return enableShp;
	}
	public void setEnableShp(String enableShp) {
		this.enableShp = enableShp;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "ShipmentType [id=" + id + ", mode=" + mode + ", code=" + code + ", enableShp=" + enableShp + ", grade="
				+ grade + ", note=" + note + "]";
	}

	
}
