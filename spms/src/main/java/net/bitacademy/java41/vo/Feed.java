package net.bitacademy.java41.vo;

import java.io.Serializable;
import java.sql.Date;

public class Feed implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int fno;
	String content;
	Date regDate;
	String email;
	int pno;
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	
	
	
}
