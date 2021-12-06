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

public class currencyConvertorCalculatorController {
	
	private boolean first = false;
	String temp1 = "";
	
	private Scene mainMenu;
	
	public void setScene(Scene scene) {
		mainMenu = scene;
	}
	
	@FXML
	public TextField pkr;
	public Label usd;
	public Label eur;
	public Label err;
	
	
	public void handlePKRClick(MouseEvent actionEvent) {
		first = true;
	}

	
	public void handleNumberClick(ActionEvent actionEvent) {
		Button btn = (Button) actionEvent.getSource();
		if(first == true) {
			temp1 = temp1.concat(btn.getText());
			pkr.setText(temp1);
		}
	}
	
	public void hanadleClickGo(ActionEvent actionEvent) {
		try {
			if(!pkr.getText().equals("")) {
				double num1 = Double.parseDouble(pkr.getText());
				double result1 = num1 * 0.0057;
				double result2 = num1 * 0.0050;
				String temp = new DecimalFormat("#.####").format(result1);
				String tempO = new DecimalFormat("#.####").format(result2);
				usd.setText(temp);
				eur.setText(tempO);
				err.setText("");
			}
		}catch(Exception e) {
			e.printStackTrace();
			err.setText("Invalid Input!");
		}
	}
	
	public void handleClickClearAll(ActionEvent actionEvent) {
		first = false;
		temp1 = "";
		pkr.setText("");
		eur.setText("");
		usd.setText("");
		err.setText("");
	}
	
	public void handleClickClear(ActionEvent actionEvent) {
		if(first == true) {
			temp1 = "";
			pkr.setText("");
			usd.setText("");
			eur.setText("");
			err.setText("");
		}
	}
	
	public void handleClickBack(ActionEvent actionEvent) {
		first = false;
		temp1 = "";
		pkr.setText("");
		eur.setText("");
		usd.setText("");
		err.setText("");
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(mainMenu);
	}
}
