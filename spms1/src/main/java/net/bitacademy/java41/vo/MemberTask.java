package net.bitacademy.java41.vo;

import java.io.Serializable;

public class MemberTask implements Serializable{

	private static final long serialVersionUID = 1L;

	int tno;
	String email;
	int pno;
	public int getTno() {
		return tno;
	}
	public MemberTask setTno(int tno) {
		this.tno = tno;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public MemberTask setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getPno() {
		return pno;
	}
	public MemberTask setPno(int pno) {
		this.pno = pno;
		return this;
	}
	
}
