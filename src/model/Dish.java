package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dish implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private List<Ingredient> ingredients;
	private List<Boolean> amounts;
	private int price;
	
	public Dish(String name, int price) {
		this.name = name;
		ingredients = new ArrayList<>();
		amounts = new ArrayList<>();
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public List<Boolean> getAmounts() {
		return amounts;
	}

	public int getPrice() {
		return price;
	}
	
	
	
}
