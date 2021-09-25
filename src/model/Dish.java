package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dish implements Serializable, Comparable<Dish>{
	private static final long serialVersionUID = 1L;
	private String name;
	private List<String> ingredients;
	private List<Double> amounts;
	private int price;
	
	public Dish(String name, List<String> ingredients, List<Double> amounts, int price) {
		this.name = name;
		ingredients = new ArrayList<>();
		amounts = new ArrayList<>();
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public List<Double> getAmounts() {
		return amounts;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public int compareTo(Dish o) {
		return name.compareTo(o.getName());
	}
	
}
