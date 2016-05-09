package org.kevinchen278.java.toxml;

import java.util.Date;

public class Policy {
	private String insuredName;
	private String phoneNumber;
	private String zip;
	private String city;
	private Date insuredDate;
	
	Policy(String insuredName, String phoneNumber, String zip, String city, Date insuredDate){
		this.insuredName = insuredName;
		this.phoneNumber = phoneNumber;
		this.zip = zip;
		this.city = city;
		this.insuredDate = insuredDate;
	}
	
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getInsuredDate() {
		return insuredDate;
	}
	public void setInsuredDate(Date insuredDate) {
		this.insuredDate = insuredDate;
	}
	
}
