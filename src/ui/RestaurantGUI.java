package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.Dish;
import model.Employee;
import model.Ingredient;
import model.Order;
import model.Restaurant;

public class RestaurantGUI {
	
	
	// MainPane
	@FXML
    private BorderPane bpMainPane;

	@FXML
    private VBox vBoxMainPane;

    @FXML
    private AnchorPane modulesPane;

    @FXML
    private AnchorPane viewListPane;

    @FXML
    private AnchorPane optionsPane;
	
	// Login Employee
	@FXML
    private TextField tfIDLoginEmp;

    @FXML
    private PasswordField pfPassLoginEmp;
	
	// Register Employee
	@FXML
	private TextField tfNameEmployee;

	@FXML
	private TextField tfIDEmployee;

	@FXML
	private PasswordField pfPassEmployee;

	@FXML
	private DatePicker dpBDay;
	
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
	
	@FXML
	public void login(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Login");
		if(tfIDLoginEmp.getText().equals("") || pfPassLoginEmp.getText().equals("")){
			alert.setContentText("Please complete all fields");
			alert.showAndWait();
		}else {
			if(restaurant.findEmployee(tfIDEmployee.getText()) != null && pfPassLoginEmp.getText().equals(restaurant.findEmployee(tfIDEmployee.getText()).getPassword())) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPane.fxml"));
			fxmlLoader.setController(this);
			Parent mainPane = fxmlLoader.load();

			bpMainPane.getChildren().clear();
			bpMainPane.setCenter(mainPane);
			
			}else {
			alert.setContentText("User not registered");
			alert.showAndWait();
			}
		}
    }
	
	@FXML
    private void registerEmployee(ActionEvent event) throws FileNotFoundException, IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Register Employee");
		if(!(tfNameEmployee.getText().equals("") || tfIDEmployee.getText().equals("") || dpBDay.getValue().toString().equals("") || pfPassEmployee.getText().equals(""))) {
			if(restaurant.getEmployees().isEmpty()){
				restaurant.addEmployee(tfNameEmployee.getText(), tfIDEmployee.getText(), dpBDay.getValue().toString(), pfPassEmployee.getText());
				alert.setContentText("Successfully registered employee");
				alert.showAndWait();
				initializeTableViewEmployee();
			}else {
				if(restaurant.findEmployee(tfIDEmployee.getText()) != null) {
					alert.setContentText("The employee had already been registered before");
					alert.showAndWait();
				}else {
					restaurant.addEmployee(tfNameEmployee.getText(), tfIDEmployee.getText(), dpBDay.getValue().toString(), pfPassEmployee.getText());
					alert.setContentText("Successfully registered employee");
					alert.showAndWait();
					initializeTableViewEmployee();
				}
			}
		}else {
			alert.setContentText("Please complete all fields");
			alert.showAndWait();
		}
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
