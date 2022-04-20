package com.barclays.ams.entity;

import java.security.SecureRandom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Users {

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	private int id;
	private long uid;
	private String passcode = "";

	private static SecureRandom random = new SecureRandom();
	private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMERIC = "0123456789";
	private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/";

	public Users() {
		this.passcode = generatePasscode(ALPHA_CAPS + ALPHA + NUMERIC + SPECIAL_CHARS);
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long l) {
		this.uid = l;
	}

	public String getPasscode() {
		return passcode;
	}

	public String generatePasscode(String sequence) {
		for (int i = 0; i < 10; i++) {
			int index = random.nextInt(sequence.length());
			this.passcode += sequence.charAt(index);
		}
		return passcode;
	}

}
