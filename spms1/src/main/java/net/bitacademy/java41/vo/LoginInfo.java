package net.bitacademy.java41.vo;

public class LoginInfo {
	String name;
	String logEmail;
	String tel;
	String photoPath;
	int level;
	String logPassword;
	
	public String getLogPassword() {
		return logPassword;
	}
	public LoginInfo setLogPassword(String logPassword) {
		this.logPassword = logPassword;
		return this;
	}
	public String getName() {
		return name;
	}
	public LoginInfo setName(String name) {
		this.name = name;
		return this;
	}
	public String getLogEmail() {
		return logEmail;
	}
	public LoginInfo setLogEmail(String logEmail) {
		this.logEmail = logEmail;
		return this;
	}
	public String getTel() {
		return tel;
	}
	public LoginInfo setTel(String tel) {
		this.tel = tel;
		return this;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public LoginInfo setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
		return this;
	}
	public int getLevel() {
		return level;
	}
	public LoginInfo setLevel(int level) {
		this.level = level;
		return this;
	}
	
}
