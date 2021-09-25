package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
    private BorderPane viewListPane;

    @FXML
    private AnchorPane optionsPane;
    
    // Options Employee
    @FXML
    private AnchorPane apOptionsEmp;

    
	
	// Login Employee
	@FXML
    private TextField tfIDLoginEmp;

    @FXML
    private PasswordField pfPassLoginEmp;
	
	// Register Employee
    @FXML
    private AnchorPane apRegisterEmp;
    
	@FXML
	private TextField tfNameEmployee;

	@FXML
	private TextField tfIDEmployee;

	@FXML
	private PasswordField pfPassEmployee;

	@FXML
	private DatePicker dpBDay;
	
	@FXML
    private Button btnRegister;
	
	// Change Password
	@FXML
    private PasswordField pfChangePassNew;

    @FXML
    private PasswordField pfChangePassOld;
    
    // Add Ingredient
    @FXML
    private AnchorPane apAddIngredient;

    @FXML
    private TextField tfNameIngredient;

    @FXML
    private TextField tfAmountIngr;

    @FXML
    private Button btnAddIngr;

    @FXML
    private TextField tfUnitIngr;
    
    // Add Menu
    @FXML
    private TextField tfNameMenu;

    @FXML
    private TextField tfNameDishMenu;
    
    // Add Dish
    @FXML
    private GridPane gpAddPane;
    
    @FXML
    private TextField tfNameDish;

    @FXML
    private Button btnAddDish;

    @FXML
    private TextField tfPriceDish;
    
    @FXML
    private TextField tfAmountIng;

    @FXML
    private ComboBox<String> cbIngredients;

    @FXML
    private ComboBox<String> cbIngredients1;

    @FXML
    private ComboBox<String> cbIngredients2;

    @FXML
    private ComboBox<String> cbIngredients3;

    @FXML
    private ComboBox<String> cbIngredients4;

    @FXML
    private ComboBox<String> cbIngredients5;

    @FXML
    private ComboBox<String> cbIngredients6;

    @FXML
    private ComboBox<String> cbIngredients7;

    @FXML
    private ComboBox<String> cbIngredients8;

    @FXML
    private ComboBox<String> cbIngredients9;

    @FXML
    private TextField tfAmountIng1;

    @FXML
    private TextField tfAmountIng2;

    @FXML
    private TextField tfAmountIng3;

    @FXML
    private TextField tfAmountIng4;

    @FXML
    private TextField tfAmountIng5;

    @FXML
    private TextField tfAmountIng6;

    @FXML
    private TextField tfAmountIng7;

    @FXML
    private TextField tfAmountIng8;

    @FXML
    private TextField tfAmountIng9;

    
    
    
	
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
	
	private List<String> dishes = new ArrayList<>();
	private List<Double> amounts = new ArrayList<>();
	
	public RestaurantGUI(Restaurant rt) {
		 restaurant = rt;    	
	}
	
	// Employee
	@FXML
	public void login(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Iniciar Sesión");
		if(tfIDLoginEmp.getText().equals("") || pfPassLoginEmp.getText().equals("")){
			alert.setContentText("Por favor llene todos los campos");
			alert.showAndWait();
		}else {
			if(restaurant.findEmployee(tfIDEmployee.getText()) != null && pfPassLoginEmp.getText().equals(restaurant.findEmployee(tfIDEmployee.getText()).getPassword())) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPane.fxml"));
			fxmlLoader.setController(this);
			Parent mainPane = fxmlLoader.load();

			Stage stage = new Stage();
	        stage.setTitle("La Cucharita");
	        stage.setScene(new Scene(mainPane));  
	        stage.show();
			}else {
			alert.setContentText("Usuario no registrado");
			alert.showAndWait();
			}
		}
    }
	
	@FXML
    private void registerEmployee(ActionEvent event) throws FileNotFoundException, IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Registrar empleado");
		if(!(tfNameEmployee.getText().equals("") || tfIDEmployee.getText().equals("") || dpBDay.getValue().toString().equals("") || pfPassEmployee.getText().equals(""))) {
			if(restaurant.getEmployees().isEmpty()){
				restaurant.addEmployee(tfNameEmployee.getText(), tfIDEmployee.getText(), dpBDay.getValue().toString(), pfPassEmployee.getText());
				alert.setContentText("Empleado registrado exitosamente");
				alert.showAndWait();
				
				Stage stage2 = (Stage) this.btnRegister.getScene().getWindow();
		        stage2.close();
		        
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPane.fxml"));
				fxmlLoader.setController(this);
				Parent mainPane = fxmlLoader.load();

				Stage stage = new Stage();
		        stage.setTitle("La Cucharita");
		        stage.setScene(new Scene(mainPane));  
		        stage.show();
		        
			}else {
				if(restaurant.findEmployee(tfIDEmployee.getText()) != null) {
					alert.setContentText("El empleado ya habia sido registrado antes");
					alert.showAndWait();
				}else {
					restaurant.addEmployee(tfNameEmployee.getText(), tfIDEmployee.getText(), dpBDay.getValue().toString(), pfPassEmployee.getText());
					alert.setContentText("Empleado registrado exitosamente");
					alert.showAndWait();
					
					Stage stage2 = (Stage) this.btnRegister.getScene().getWindow();
			        stage2.close();
					
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPane.fxml"));
					fxmlLoader.setController(this);
					Parent mainPane = fxmlLoader.load();

					Stage stage = new Stage();
			        stage.setTitle("La Cucharita");
			        stage.setScene(new Scene(mainPane));  
			        stage.show();
			        
				}
			}
		}else {
			alert.setContentText("Por favor llene todos los campos");
			alert.showAndWait();
		}
    }
	
	@FXML
    private void changePassword(ActionEvent event) {
		
    }
	
	// Ingredient
	@FXML
	private void AddIngredient(ActionEvent event) throws FileNotFoundException, IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Añadir ingrediente");
		if(!(tfNameIngredient.getText().equals("") || tfAmountIngr.getText().equals("") || tfUnitIngr.getText().equals(""))) {
			if(restaurant.getIngredients().isEmpty()){
				double amount = Double.parseDouble(tfAmountIngr.getText());
				restaurant.addIngredient(tfNameIngredient.getText(), amount, tfUnitIngr.getText());
				alert.setContentText("Ingrediente añadido exitosamente");
				alert.showAndWait();
				
				Stage stage2 = (Stage) this.btnAddIngr.getScene().getWindow();
		        stage2.close();
			}else {
				if(restaurant.findIngredient(tfNameIngredient.getText()) != null) {
					alert.setContentText("El ingrediente ya habia sido añadido antes");
					alert.showAndWait();
				}else {
					double amount = Double.parseDouble(tfAmountIngr.getText());
					restaurant.addIngredient(tfNameIngredient.getText(), amount, tfUnitIngr.getText());
					alert.setContentText("Ingrediente añadido exitosamente");
					alert.showAndWait();
					
					Stage stage2 = (Stage) this.btnAddIngr.getScene().getWindow();
			        stage2.close();
				}
			}
		}else {
			alert.setContentText("Por favor llene todos los campos");
			alert.showAndWait();
		}
    }
	
	// Dish
	private void addIngtoComboBox(ComboBox<String> x){
        for(int i=0;i<restaurant.getIngredients().size();i++){
        	x.getItems().add(restaurant.getIngredients().get(i).getName());
        }
    }
	
	private void addToList() {
		if(!(cbIngredients.getValue().equals("") && tfAmountIng.getText().equals(""))) {
			dishes.add(cbIngredients.getValue());
			double amount = Double.parseDouble(tfAmountIng.getText());
			amounts.add(amount);
		}
		if(!(cbIngredients1.getValue().equals("") && tfAmountIng1.getText().equals(""))) {
			dishes.add(cbIngredients1.getValue());
			double amount = Double.parseDouble(tfAmountIng1.getText());
			amounts.add(amount);
		}
		if(!(cbIngredients2.getValue().equals("") && tfAmountIng2.getText().equals(""))) {
			dishes.add(cbIngredients2.getValue());
			double amount = Double.parseDouble(tfAmountIng2.getText());
			amounts.add(amount);
		}
		if(!(cbIngredients3.getValue().equals("") && tfAmountIng3.getText().equals(""))) {
			dishes.add(cbIngredients3.getValue());
			double amount = Double.parseDouble(tfAmountIng3.getText());
			amounts.add(amount);
		}
		if(!(cbIngredients4.getValue().equals("") && tfAmountIng4.getText().equals(""))) {
			dishes.add(cbIngredients4.getValue());
			double amount = Double.parseDouble(tfAmountIng4.getText());
			amounts.add(amount);
		}
		if(!(cbIngredients5.getValue().equals("") && tfAmountIng5.getText().equals(""))) {
			dishes.add(cbIngredients5.getValue());
			double amount = Double.parseDouble(tfAmountIng5.getText());
			amounts.add(amount);
		}
		if(!(cbIngredients6.getValue().equals("") && tfAmountIng6.getText().equals(""))) {
			dishes.add(cbIngredients6.getValue());
			double amount = Double.parseDouble(tfAmountIng6.getText());
			amounts.add(amount);
		}
		if(!(cbIngredients7.getValue().equals("") && tfAmountIng7.getText().equals(""))) {
			dishes.add(cbIngredients7.getValue());
			double amount = Double.parseDouble(tfAmountIng7.getText());
			amounts.add(amount);
		}
		if(!(cbIngredients8.getValue().equals("") && tfAmountIng8.getText().equals(""))) {
			dishes.add(cbIngredients8.getValue());
			double amount = Double.parseDouble(tfAmountIng8.getText());
			amounts.add(amount);
		}
		if(!(cbIngredients9.getValue().equals("") && tfAmountIng9.getText().equals(""))) {
			dishes.add(cbIngredients9.getValue());
			double amount = Double.parseDouble(tfAmountIng9.getText());
			amounts.add(amount);
		}
	}
	
	@FXML
	private void AddIngredientToMenu(ActionEvent event) throws FileNotFoundException, IOException {
		addIngtoComboBox(cbIngredients);
		addIngtoComboBox(cbIngredients1);
		addIngtoComboBox(cbIngredients2);
		addIngtoComboBox(cbIngredients3);
		addIngtoComboBox(cbIngredients4);
		addIngtoComboBox(cbIngredients5);
		addIngtoComboBox(cbIngredients6);
		addIngtoComboBox(cbIngredients7);
		addIngtoComboBox(cbIngredients8);
		addIngtoComboBox(cbIngredients9);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Añadir platillo");
		if(!(tfNameDish.getText().equals("") || tfPriceDish.getText().equals("") || cbIngredients.getValue().equals("") || tfAmountIng.getText().equals(""))) {
			if(restaurant.getDishes().isEmpty()){
				int price = Integer.parseInt(tfPriceDish.getText());
				addToList();
				restaurant.addDish(tfNameDish.getText(), dishes, amounts, price);
				alert.setContentText("Platillo añadido exitosamente");
				alert.showAndWait();
				
				Stage stage2 = (Stage) this.btnAddDish.getScene().getWindow();
		        stage2.close();
			}else {
				if(restaurant.findDish(tfNameDish.getText()) != null) {
					alert.setContentText("El platillo ya habia sido añadido antes");
					alert.showAndWait();
				}else {
					int price = Integer.parseInt(tfPriceDish.getText());
					addToList();
					restaurant.addDish(tfNameDish.getText(), dishes, amounts, price);
					alert.setContentText("Platillo añadido exitosamente");
					alert.showAndWait();
					
					Stage stage2 = (Stage) this.btnAddDish.getScene().getWindow();
			        stage2.close();
				}
			}
		}else {
			alert.setContentText("Por favor llene todos los campos");
			alert.showAndWait();
		}
    }

	
	// View Info
	@FXML
	private void viewEmployeeInfo(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmployeeList.fxml"));
    	fxmlLoader.setController(this);
    	Parent EmpListPane = fxmlLoader.load();
    
    	viewListPane.setCenter(EmpListPane);
		initializeTableViewEmployee();
		
		FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("optionsEmp.fxml"));
    	fxmlLoader1.setController(this);
    	Parent EmpListPane1 = fxmlLoader1.load();
    
    	viewListPane.setCenter(EmpListPane1);
		initializeTableViewEmployee();
    }

    @FXML
    private void viewInventoryInfo(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InventoryList.fxml"));
    	fxmlLoader.setController(this);
    	Parent EmpListPane = fxmlLoader.load();
    
    	viewListPane.setCenter(EmpListPane);
    	initializeTableViewIngredient();
    }

    @FXML
    private void viewMenuInfo(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuList.fxml"));
    	fxmlLoader.setController(this);
    	Parent EmpListPane = fxmlLoader.load();
    
    	viewListPane.setCenter(EmpListPane);
    	initializeTableViewMenu();
    }

    @FXML
    private void viewOrdersInfo(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderList.fxml"));
    	fxmlLoader.setController(this);
    	Parent EmpListPane = fxmlLoader.load();
    
    	viewListPane.setCenter(EmpListPane);
    	initializeTableViewOrder();
    }
    
    // Tables
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
