package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	private String code;
	private String status;
	private String date;
	private List<Dish> dishes;
	
	public Order(String code, String status, String date) {
		this.code = code;
		this.status = status;
		this.date = date;
		dishes = new ArrayList<>();
	}

	public String getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public String getDate() {
		return date;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
