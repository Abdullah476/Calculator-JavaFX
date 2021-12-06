package application;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class discountCalculatorController {
	private boolean first = false;
	private boolean second = false;
	private String temp1 = ""; 
	private String temp2 = "";
	
	private Scene mainMenu;
	
	public void setScene(Scene scene) {
		mainMenu = scene;
	}
	
	@FXML
	public TextField originalPrice;
	public TextField discountPercent;
	public Label finalPrice;
	public Label saveDisplay;
	
	
	public void handlePriceClick(MouseEvent actionEvent) {
		second = false;
		first = true;
	}

	public void handleDiscountClick(MouseEvent actionEvent) {
		first = false;
		second = true;
	}
	
	public void handleNumberClick(ActionEvent actionEvent) {
		Button btn = (Button) actionEvent.getSource();
		if(first == true) {
			temp1 = temp1.concat(btn.getText());
			originalPrice.setText(temp1);
		}
		else if(second == true) {
			temp2 = temp2.concat(btn.getText());
			discountPercent.setText(temp2);
		}
		
	}
	
	public void hanadleClickGo(ActionEvent actionEvent) {
		try {
			if(!originalPrice.getText().equals("") && !discountPercent.getText().equals("")) {
				double num1 = Double.parseDouble(originalPrice.getText());
				double num2 = Double.parseDouble(discountPercent.getText());
				double tAmount = num1 * (num2 / 100);
				double result = num1 - tAmount;
				String temp = new DecimalFormat("#.##").format(result);
				finalPrice.setText(temp);
				String tempO = new DecimalFormat("#.##").format(tAmount);
				saveDisplay.setText("You Save " + tempO);
			}
		}catch(Exception e) {
			e.printStackTrace();
			saveDisplay.setText("Invalid Inputs!");
		}
	}
	
	public void handleClickClearAll(ActionEvent actionEvent) {
		first = false;
		second = false;
		temp1 = "";
		temp2 = "";
		originalPrice.setText("");
		discountPercent.setText("");
		finalPrice.setText("");
		saveDisplay.setText("");
	}
	
	public void handleClickClear(ActionEvent actionEvent) {
		if(first == true) {
			temp1 = "";
			originalPrice.setText("");
		}
		else if(second == true) {
			temp2 = "";
			discountPercent.setText("");
		}
	}
	
	public void handleClickBack(ActionEvent actionEvent) {
		first = false;
		second = false;
		temp1 = "";
		temp2 = "";
		originalPrice.setText("");
		discountPercent.setText("");
		finalPrice.setText("");
		saveDisplay.setText("");
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(mainMenu);
	}
}
