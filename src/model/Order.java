package model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable, Comparable<Order>{
	private static final long serialVersionUID = 1L;
	private String code;
	private StatusDish status;
	private Date date;
	private String dishes;
	
	public Order(String code, StatusDish status, Date date, String dishes) {
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

	public Date getDate() {
		return date;
	}

	public String getDishes() {
		return dishes;
	}

	public void setStatus(StatusDish status) {
		this.status = status;
	}

	@Override
	public int compareTo(Order o) {
		return getDate().compareTo(o.getDate());
	}

}
