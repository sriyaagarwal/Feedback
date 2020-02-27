package com.cg.iter.feedbackmanagementsystem.service.entity;

public class Center {
	public Center(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
		this.centerId=string;
		this.centerAddress=string3;
		this.centerName=string2;
	}

	/**
	 * 
	 */
	public String centerId;

	/**
	 * 
	 */
	public String centerName;

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterAddress() {
		return centerAddress;
	}

	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

	/**
	 * 
	 */
	public String centerAddress;

}