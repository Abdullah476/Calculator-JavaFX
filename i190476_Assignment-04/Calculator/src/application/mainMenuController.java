package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainMenuController {
	private Scene ageScene;
	private Scene bmiScene;
	private Scene calculatorScene;
	private Scene currencyScene;
	private Scene discountScene;
	private Scene investmentScene;
	
	public void setAge(Scene scene) {
		ageScene = scene;
	}
	
	public void setBmi(Scene scene) {
		bmiScene = scene;
	}
	
	public void setCalculator(Scene scene) {
		calculatorScene = scene;
	}
	
	public void setCurrency(Scene scene) {
		currencyScene = scene;
	}
	
	public void setDisount(Scene scene) {
		discountScene = scene;
	}
	
	public void setInvestment(Scene scene) {
		investmentScene = scene;
	}
	
	@FXML
	public void clickAge(ActionEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(ageScene);
	}
	
	@FXML
	public void clickBmi(ActionEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(bmiScene);
	}
	
	@FXML
	public void clickCalculator(ActionEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(calculatorScene);
	}
	
	@FXML
	public void clickCurrency(ActionEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(currencyScene);
	}
	
	@FXML
	public void clickDiscount(ActionEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(discountScene);
	}
	
	@FXML
	public void clickInvestment(ActionEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(investmentScene);
	}
}

