package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private List<Employee> employees;
	private List<Ingredient> ingredients;
	private List<Dish> dishes;
	private List<Order> orders;
	
	public Restaurant() {
		employees = new ArrayList<>();
		ingredients = new ArrayList<>();
		dishes = new ArrayList<>();
		orders = new ArrayList<>();
	}
	
	// Employee
	public void addEmployee(String name, String numID, String bDay, String pw) {
		Employee employee = new Employee(name, numID, bDay, pw);
		employees.add(employee);
	}
	
	private void deleteEmployee(Employee e) {
		employees.remove(e);
	}
	
	public void findEmployee(String numID) {
		for(int i=0; i<employees.size(); i++) {
			if(employees.get(i).getNumID().equals(numID)) {
				deleteEmployee(employees.get(i));
			}
		}
	}
	
	public void changePassword(String newPw) {
		
	}
	
	// Ingredients
	public void addIngredient(String name, boolean amount, String unit) {
		Ingredient ingredient = new Ingredient(name, amount, unit);
		ingredients.add(ingredient);
	}
	
	private void deleteIngredient(Ingredient i) {
		ingredients.remove(i);
	}
	
	public void findIngredient(String name) {
		for(int i=0; i<ingredients.size(); i++) {
			if(ingredients.get(i).getName().equals(name)) {
				deleteIngredient(ingredients.get(i));
			}
		}
	}
	
	
}
