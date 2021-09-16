package model;

import java.io.Serializable;

public class Ingredient implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private double amount;
	private String unit;
	
	public Ingredient(String name, double amount, String unit) {
		this.name = name;
		this.amount = amount;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
