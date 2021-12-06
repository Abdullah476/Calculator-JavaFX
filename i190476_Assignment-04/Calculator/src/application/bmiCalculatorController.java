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

public class bmiCalculatorController {
	
	private boolean first = false;
	private boolean second = false;
	private String temp1 = ""; 
	private String temp2 = "";
	
	private Scene mainMenu;
	
	public void setScene(Scene scene) {
		mainMenu = scene;
	}
	
	@FXML
	public TextField weight;
	public TextField height;
	public Label bmi;
	
	
	public void handleWeightClick(MouseEvent actionEvent) {
		second = false;
		first = true;
	}

	public void handleHeightClick(MouseEvent actionEvent) {
		first = false;
		second = true;
	}
	
	public void handleNumberClick(ActionEvent actionEvent) {
		Button btn = (Button) actionEvent.getSource();
		if(first == true) {
			temp1 = temp1.concat(btn.getText());
			weight.setText(temp1);
		}
		else if(second == true) {
			temp2 = temp2.concat(btn.getText());
			height.setText(temp2);
		}
		
	}
	
	public void hanadleClickGo(ActionEvent actionEvent) {
		try {
			if(!weight.getText().equals("") && !height.getText().equals("")) {
				double num1 = Double.parseDouble(weight.getText());
				double num2 = Double.parseDouble(height.getText());
				double result = num1 / ((num2 / 100) * (num2 / 100));
				String temp = new DecimalFormat("#.##").format(result);
				bmi.setText(temp);
			}
		}catch(Exception e) {
			e.printStackTrace();
			bmi.setText("Invalid Inputs!");
		}
	}
	
	public void handleClickClearAll(ActionEvent actionEvent) {
		first = false;
		second = false;
		temp1 = "";
		temp2 = "";
		weight.setText("");
		height.setText("");
		bmi.setText("");
	}
	
	public void handleClickClear(ActionEvent actionEvent) {
		if(first == true) {
			temp1 = "";
			weight.setText("");
		}
		else if(second == true) {
			temp2 = "";
			height.setText("");
		}
	}
	
	public void handleClickBack(ActionEvent actionEvent) {
		first = false;
		second = false;
		temp1 = "";
		temp2 = "";
		weight.setText("");
		height.setText("");
		bmi.setText("");
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(mainMenu);
	}
	
}
