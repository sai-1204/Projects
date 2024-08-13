package com.virtusa.obtbs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_tb")
public class AdminDTO {

	@Id
	@Column(name="adminid",nullable = false)
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminID;
	@Column(name="adminname",length = 20,nullable = false)
	private String adminName;
	@Column(name="adminpassword",length = 20,nullable = false)
	private String adminPassword;
	public AdminDTO() {
		
	}
	public AdminDTO(String adminName, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "AdminDTO [adminID=" + adminID + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
	
	
}
