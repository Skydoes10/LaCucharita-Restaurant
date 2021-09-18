package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurant {
	public String EMPLOYEES_FILE_NAME = "data/employees.emp";
	public String INGREDIENTS_FILE_NAME = "data/ingredients.ing";
	public String DISHES_FILE_NAME = "data/dishes.dsh";
	public String ORDERS_FILE_NAME = "data/orders.ord";
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
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public List<Order> getOrders() {
		return orders;
	}

	// Employee
	public void addEmployee(String name, String numID, String bDay, String pw) throws FileNotFoundException, IOException {
		Employee employee = new Employee(name, numID, bDay, pw);
		employees.add(employee);
		sortByNameEmployee();
		saveEmployees();
	}
	
	private void deleteEmployee(Employee e) throws FileNotFoundException, IOException {
		employees.remove(e);
		sortByNameEmployee();
		saveEmployees();
	}
	
	public Employee findEmployee(String numID) {
		Employee employee = null;
		for(int i=0; i<employees.size(); i++) {
			if(employees.get(i).getNumID().equals(numID)) {
				employee = employees.get(i);
//				deleteEmployee(employees.get(i));
			}
		}
		return employee;
	}
	
	public void changePassword(String newPw) {
		
	}
	
	// Ingredient
	public void addIngredient(String name, double amount, String unit) throws FileNotFoundException, IOException {
		Ingredient ingredient = new Ingredient(name, amount, unit);
		ingredients.add(ingredient);
		sortByNameIngr();
		saveIngredient();
	}
	
	private void deleteIngredient(Ingredient i) throws FileNotFoundException, IOException {
		ingredients.remove(i);
		sortByNameIngr();
		saveIngredient();
	}
	
	public Ingredient findIngredient(String name) {
		Ingredient ingredient = null;
		for(int i=0; i<ingredients.size(); i++) {
			if(ingredients.get(i).getName().equals(name)) {
				ingredient = ingredients.get(i);
//				deleteIngredient(ingredients.get(i));
			}
		}
		return ingredient;
	}
	
	public void changeAmount(boolean newAmount) {
		
	}
	
	// Dish
	public void addDish(String name, int price) throws FileNotFoundException, IOException {
		Dish dish = new Dish(name, price);
		dishes.add(dish);
		sortByNameDish();
		saveDish();
	}
	
	private void deleteDish(Dish d) throws FileNotFoundException, IOException {
		dishes.remove(d);
		sortByNameDish();
		saveDish();
	}
	
	public Dish findDish(String name) {
		Dish dish = null;
		for(int i=0; i<dishes.size(); i++) {
			if(dishes.get(i).getName().equals(name)) {
				dish = dishes.get(i);
//				deleteDish(dishes.get(i));
			}
		}
		return dish;
	}
	
	// Order
	public void addOrder(String code, String status, String date) throws FileNotFoundException, IOException {
		Order order = new Order(code, status, date);
		orders.add(order);
		saveOrder();
	}
	
	public void deleteOrder(Order o) throws FileNotFoundException, IOException {
		orders.remove(o);
		saveOrder();
	}
	
	public Order findOrder(String code) {
		Order order = null;
		for(int i=0; i<orders.size(); i++) {
			if(orders.get(i).getCode().equals(code)) {
				order = orders.get(i);
			}
		}
		return order;
	}
	
	public void changeStatus(String code, String newStatus) {
		
	}
	
	// Serialization Employee
	private void saveEmployees() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EMPLOYEES_FILE_NAME));
		oos.writeObject(employees);
		oos.close();
	}
	
	private void loadEmployees() throws IOException, ClassNotFoundException {
		File f = new File(EMPLOYEES_FILE_NAME);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			employees = (ArrayList<Employee>) ois.readObject();
			ois.close();
		}
	}
	
	// Serialization Ingredient
	private void saveIngredient() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INGREDIENTS_FILE_NAME));
		oos.writeObject(ingredients);
		oos.close();
	}
	
	private void loadIngredient() throws IOException, ClassNotFoundException {
		File f = new File(INGREDIENTS_FILE_NAME);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			ingredients = (ArrayList<Ingredient>) ois.readObject();
			ois.close();
		}
	}
	
	// Serialization Dish
	private void saveDish() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DISHES_FILE_NAME));
		oos.writeObject(dishes);
		oos.close();
	}
	
	private void loadDish() throws IOException, ClassNotFoundException {
		File f = new File(DISHES_FILE_NAME);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			dishes = (ArrayList<Dish>) ois.readObject();
			ois.close();
		}
	}
	
	// Serialization Order
	private void saveOrder() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ORDERS_FILE_NAME));
		oos.writeObject(orders);
		oos.close();
	}
	
	private void loadOrder() throws IOException, ClassNotFoundException {
		File f = new File(ORDERS_FILE_NAME);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			orders = (ArrayList<Order>) ois.readObject();
			ois.close();
		}
	}
	
	// Sort
	private void sortByNameEmployee() {
		int j;
		Employee aux;
		
		for(int i = 1; i < employees.size(); i++) {
			aux = employees.get(i);
			j = i-1;
			while((j >= 0) && (aux.compareByName(employees.get(j)) < 0)) {
				employees.set(j+1, employees.get(j));
				j--;
			}
			employees.set(j+1, aux);
		}
	}
	
	private void sortByNameIngr() {
	    for (int i = 0; i < ingredients.size(); i++) {
	        for (int j = 0; j < ingredients.size(); j++) {
	            if(ingredients.get(i).getName().compareTo(ingredients.get(j).getName()) < 0) {
	                Ingredient aux = ingredients.get(i);
	                ingredients.set(i, ingredients.get(j));
	                ingredients.set(j, aux);
	            }
	        }
	    }
	}
	
	public void sortByNameDish() {
		Collections.sort(dishes);
	}
	
	//
	// pendiente el sort de order
	//
	
	
}
