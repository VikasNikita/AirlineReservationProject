package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ADMIN_ID")
	private int adminId;
	
	@Column(name = "ADMIN_PASSWARD")
	private String adminPassward;
	/*
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminId, String adminPassward) {
		super();
		this.adminId = adminId;
		this.adminPassward = adminPassward;
	}
*/
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassward() {
		return adminPassward;
	}

	public void setAdminPassward(String adminPassward) {
		this.adminPassward = adminPassward;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPassward=" + adminPassward + "]";
	}
	
	
}
