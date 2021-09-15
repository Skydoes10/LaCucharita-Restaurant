package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Restaurant;

public class Main extends Application{
	private RestaurantGUI restaurantGUI;
	private Restaurant restaurant;

	public static void main(String[] args) {
		launch(args);
	}
	
	public Main() {
		restaurant = new Restaurant();
		restaurantGUI = new RestaurantGUI(restaurant);
	}

	@Override
	public void start(Stage primaryStage) throws Exception  {
		if(restaurant.getEmployees().isEmpty()) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterEmployee.fxml"));
			fxmlLoader.setController(restaurantGUI);
			
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root); 
			primaryStage.setScene(scene);
			primaryStage.setTitle("Registrar Empleado");
			primaryStage.show();
			
		}else {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
			fxmlLoader.setController(restaurantGUI);
			
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root); 
			primaryStage.setScene(scene);
			primaryStage.setTitle("Iniciar Sesión");
			primaryStage.show();
		}
		
	}

}
