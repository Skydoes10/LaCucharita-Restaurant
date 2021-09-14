package model;

import java.io.Serializable;

public class Dish implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private boolean amount;
	private String unit;
	
	public Dish(String name, boolean amount, String unit) {
		this.name = name;
		this.amount = amount;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public boolean isAmount() {
		return amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setAmount(boolean amount) {
		this.amount = amount;
	}
	
	
}
