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
@Table(
		name = "whusertypetab"
		)
public final class WhUserType {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	private String userType;
	private String code;
	private String userFor;
	private String userEmail;
	private String contact;
	private String userIdType;
	private String ifOther;
	private String idNum;
	private String note;
	public WhUserType() {
		super();
	}
	public WhUserType(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserFor() {
		return userFor;
	}
	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getUserIdType() {
		return userIdType;
	}
	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}
	public String getIfOther() {
		return ifOther;
	}
	public void setIfOther(String ifOther) {
		this.ifOther = ifOther;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "WhUserType [id=" + id + ", userType=" + userType + ", code=" + code + ", userFor=" + userFor
				+ ", userEmail=" + userEmail + ", contact=" + contact + ", userIdType=" + userIdType + ", ifOther="
				+ ifOther + ", idNum=" + idNum + ", note=" + note + "]";
	}
	
	
	
	
	
}
