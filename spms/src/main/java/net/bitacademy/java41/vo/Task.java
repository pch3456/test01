package net.bitacademy.java41.vo;

import java.sql.Date;


public class Task {
	
	int tno;
	int pno;
	String title;
	String UIProtoURL;
	String context;
	Date startDate;
	Date endDate;
	int status;
	String email;
	
	
	public String getEmail() {
		return email;
	}
	public Task setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getTno() {
		return tno;
	}
	public Task setTno(int tno) {
		this.tno = tno;
		return this;
	}
	public int getPno() {
		return pno;
	}
	public Task setPno(int pno) {
		this.pno = pno;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Task setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getUIProtoURL() {
		return UIProtoURL;
	}
	public Task setUIProtoURL(String uIProtoURL) {
		UIProtoURL = uIProtoURL;
		return this;
	}
	public String getContext() {
		return context;
	}
	public Task setContext(String context) {
		this.context = context;
		return this;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Task setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Task setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}
	public int getStatus() {
		return status;
	}
	public Task setStatus(int status) {
		this.status = status;
		return this;
	}
	
}
