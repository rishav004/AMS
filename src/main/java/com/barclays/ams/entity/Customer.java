package com.barclays.ams.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Customer {

	private static final long CONSUMER_ID_START = 8_00_000L;

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	private int id;
	@Min(value = 10)
	@Max(value = 10)
	private String pan;
	@Min(value = 12)
	@Max(value = 12)
	private String aadhar;
	private String name;
	private String address;
	private String email;
	private String dob;
	@Min(value = 6)
	@Max(value = 6)
	private long cid;

	public int getId() {
		setCid();
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public long getCid() {
		return cid;
	}

	public void setCid() {
		this.cid = (long) Math.floor(Math.random() * 1_00_000L) + CONSUMER_ID_START;
	}

}
