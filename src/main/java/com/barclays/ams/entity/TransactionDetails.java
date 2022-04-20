package com.barclays.ams.entity;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "transaction_details")
public class TransactionDetails {

	private static SecureRandom random = new SecureRandom();
	private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUMERIC = "0123456789";

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	private int id;

	private long cid;
	private long accno;
	private String transactionid = "";
	private String referenceno = "";
	private LocalDate date;
	private LocalTime time;

	private String type;
	private String subtype;
	private float amount;
	private float balance;

	public TransactionDetails() {
		super();
		this.transactionid = generateTransactionid(ALPHA + NUMERIC);
		this.referenceno = generateReferenceno(NUMERIC);
		this.date = LocalDate.now();
		this.time = LocalTime.now();
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public String generateTransactionid(String sequence) {
		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(sequence.length());
			this.transactionid += sequence.charAt(index);
		}
		return transactionid;
	}

	public String getReferenceno() {
		return referenceno;
	}

	public String generateReferenceno(String sequence) {
		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(sequence.length());
			this.referenceno += sequence.charAt(index);
		}
		return referenceno;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getTime() {
		return time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
