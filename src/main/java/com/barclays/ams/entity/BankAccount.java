package com.barclays.ams.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "bank_account")
public class BankAccount {

	private final static long ACCOUNT_NUMBER_START = 5_00_00_00_000L;

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	private int id;
	private long cid;
	private long accno;
	private float balance;

	public BankAccount() {

	}

	public BankAccount(int id, long cid, long accno) {
		super();
		this.id = id;
		this.cid = cid;
		this.accno = accno;
		this.balance = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		setAccno();
		this.cid = cid;
	}

	public long getAccno() {
		return accno;
	}

	public void setAccno() {
		this.accno = (long) Math.floor(Math.random() * 1_00_00_000L) + ACCOUNT_NUMBER_START;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float bal) {
		this.balance = bal;
	}

	@Override
	public String toString() {
		return "BankAccount [cid=" + cid + ", accno=" + accno + "]";
	}

}
