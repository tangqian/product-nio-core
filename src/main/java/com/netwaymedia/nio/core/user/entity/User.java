package com.netwaymedia.nio.core.user.entity;

import java.io.Serializable;

import com.netwaymedia.nio.core.base.SuperEntity;

public class User extends SuperEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public String getRegisterAgent() {
		return registerAgent;
	}

	public void setRegisterAgent(String registerAgent) {
		this.registerAgent = registerAgent;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	private String account; // 登录账户名

	private Integer userStatus; // 用户状态

	private Integer userType; // 用户类型

	private String email;

	private String registerIp; // 注册IP
	
	private String registerAgent; // 注册时使用的User-Agent
	
	private String ticketNo; // 用户识别码，用户唯一

}
