package net.bitacademy.java41.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.stereotype.Component;

@Component
public class DBConnectionPool {
	String dburl;
	String id;
	String pwd;
	String driverClass;
	
	ArrayList<Connection> list = new ArrayList<Connection>();
	Hashtable<Thread , Connection > rentTable = new Hashtable<Thread,Connection>();

	public DBConnectionPool() {}
	
	public DBConnectionPool(
			String dburl, String id, String pwd, String driverClass) {
		this.dburl = dburl;
		this.id = id;
		this.pwd = pwd;
		this.driverClass = driverClass;
	}
	
	public DBConnectionPool setUrl(String url){
		this.dburl = url;
		return this;
	}
	
	public DBConnectionPool setDriver(String driver){
		this.driverClass = driver;
		return this;
	}
	
	public DBConnectionPool setUsername(String username){
		this.id = username;
		return this;
	}
	
	public DBConnectionPool setPassword(String password){
		this.pwd = password;
		return this;
	}
	
	public Connection getConnection() throws Exception {
		Thread currThread = Thread.currentThread(); 

		Connection con = rentTable.get(currThread);  
		if(con!= null){
			return con;
		}else {
			if (list.size() > 0) { 
				con = list.remove(0);
			} else {  
				Class.forName(driverClass);
				con = DriverManager.getConnection(dburl, id, pwd);
			}
			rentTable.put(currThread, con); 
			return con; 
		}
	}
	
	public void returnConnection(Connection con) {
		Thread currThread = Thread.currentThread(); 
		rentTable.remove(currThread); 
		list.add(con); 
	}
}







