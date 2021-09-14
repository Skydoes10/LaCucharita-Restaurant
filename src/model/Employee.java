package model;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String numID;
	private String birthday;
	private String password;
	
	public Employee(String name, String numID, String birthday, String password) {
		this.name = name;
		this.numID = numID;
		this.birthday = birthday;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getNumID() {
		return numID;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
