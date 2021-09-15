package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Dish;
import model.Employee;
import model.Ingredient;
import model.Order;
import model.Restaurant;

public class RestaurantGUI {
	
	
	
	// TableView Employee
	@FXML
    private TableView<Employee> tvEmployee;

    @FXML
    private TableColumn<Employee, String> tcName;

    @FXML
    private TableColumn<Employee, String> tcNumID;
    
    @FXML
    private TableColumn<Employee, String> tcBDay;
    
    // TableView Inventory
    @FXML
    private TableView<Ingredient> tvInventoryList;

    @FXML
    private TableColumn<Ingredient, String> tcNameIngredient;

    @FXML
    private TableColumn<Ingredient, String> tcAmountIngredient;

    @FXML
    private TableColumn<Ingredient, String> tcUnitIngredient;
    
    // TableView Menu
    @FXML
    private TableView<Dish> tvMenuList;

    @FXML
    private TableColumn<Dish, String> tcDishName;

    @FXML
    private TableColumn<Dish, String> tcIngredients;

    @FXML
    private TableColumn<Dish, String> tcPrice;
    
    // TableView Order
    @FXML
    private TableView<Order> tvOrdersList;

    @FXML
    private TableColumn<Order, String> tcCodeOrder;

    @FXML
    private TableColumn<Order, String> tcDishes;

    @FXML
    private TableColumn<Order, String> tcStatusDish;

    @FXML
    private TableColumn<Order, String> tcDateOrder;
	
	private Restaurant restaurant;
	
	public RestaurantGUI(Restaurant rt) {
		 restaurant = rt;    	
	}
	
	private void initializeTableViewEmployee() {
		ObservableList<Employee> observableList;
   		observableList = FXCollections.observableArrayList(restaurant.getEmployees());
   	
   		tvEmployee.setItems(observableList);
   		tcName.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
   		tcNumID.setCellValueFactory(new PropertyValueFactory<Employee,String>("numID"));
   		tcBDay.setCellValueFactory(new PropertyValueFactory<Employee,String>("birthday"));
	}
	
	private void initializeTableViewIngredient() {
		ObservableList<Ingredient> observableList;
   		observableList = FXCollections.observableArrayList(restaurant.getIngredients());
   	
   		tvInventoryList.setItems(observableList);
   		tcNameIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("name"));
   		tcAmountIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("amount"));
   		tcUnitIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("unit"));
   }
	
	private void initializeTableViewMenu() {
		ObservableList<Dish> observableList;
   		observableList = FXCollections.observableArrayList(restaurant.getDishes());
   	
   		tvMenuList.setItems(observableList);
   		tcDishName.setCellValueFactory(new PropertyValueFactory<Dish, String>("name"));
   		tcIngredients.setCellValueFactory(new PropertyValueFactory<Dish, String>(""));
   		tcPrice.setCellValueFactory(new PropertyValueFactory<Dish, String>("price"));
	}
	
	private void initializeTableViewOrder() {
		ObservableList<Order> observableList;
   		observableList = FXCollections.observableArrayList(restaurant.getOrders());
   	
   		tvOrdersList.setItems(observableList);
   		tcCodeOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("code"));
   		tcDishes.setCellValueFactory(new PropertyValueFactory<Order, String>(""));
   		tcStatusDish.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));
   		tcDateOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
	}
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
}
