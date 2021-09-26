package model;

import java.io.Serializable;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	private String code;
	private StatusDish status;
	private String date;
	private String dishes;
	
	public Order(String code, StatusDish status, String date, String dishes) {
		this.code = code;
		this.status = status;
		this.date = date;
		this.dishes = dishes;
	}

	public String getCode() {
		return code;
	}

	public StatusDish getStatus() {
		return status;
	}

	public String getDate() {
		return date;
	}

	public String getDishes() {
		return dishes;
	}

	public void setStatus(StatusDish status) {
		this.status = status;
	}

	
	
}
