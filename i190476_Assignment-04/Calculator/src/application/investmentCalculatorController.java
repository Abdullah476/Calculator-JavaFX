package application;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class investmentCalculatorController {
	
	private Scene mainMenu;
	
	public void setScene(Scene scene) {
		mainMenu = scene;
	}
	
	@FXML
	public TextField investment;
	public TextField annualRate;
	public TextField years;
	public TextField months;
	public Label finalValue;
	public Label error;
	
	public void handleCalculate(ActionEvent actionEvent) {
		try {
			int numYears = Integer.parseInt(years.getText());
			int numMonths = Integer.parseInt(months.getText());
			double inv = Double.parseDouble(investment.getText());
			double rate = Double.parseDouble(annualRate.getText());
			
			double fValue = inv * Math.pow(1 + rate/1200, (numYears * 12) + numMonths);
			String temp = new DecimalFormat("#.###").format(fValue);
			finalValue.setText("$" + temp);
			error.setText("");
		}catch(Exception e) {
			e.printStackTrace();
			error.setText("Invalid Inputs!");
			finalValue.setText("");
		}
	}	
	
	public void handleClickBack(ActionEvent actionEvent) {
		investment.setText("");
		annualRate.setText("");
		years.setText("");
		months.setText("");
		finalValue.setText("");
		error.setText("");
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(mainMenu);
	}

}
