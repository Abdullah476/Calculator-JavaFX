package application;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CalculatorController {

	boolean status = false;
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    String first = "";
    char two;
    
    private Scene mainMenu;
	
	public void setScene(Scene scene) {
		mainMenu = scene;
	}
    
    @FXML
    public Label ans;

    public void handleClickNumber(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        first = first.concat(btn.getText());
        ans.setText(first);
    }
    
    public void handleClickOperand(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        if(!status){
            num1 = Double.parseDouble(ans.getText());
            ans.setText("");
            two = btn.getText().charAt(0);
            status = true;
            first = "";
        }
        else{
            num2 = Double.parseDouble(ans.getText());
            if(two == '+'){
                result = num1 + num2;
            }
            if(two == '-'){
                result = num1 - num2;
            }
            if(two == '/'){
                result = num1 / num2;
            }
            if(two == 'x'){
                result = num1 * num2;
            }
            if(two == '%') {
            	result = num1 % num2;
            }
            String temp = new DecimalFormat ("#.####").format(result);
            ans.setText(temp);
            two = btn.getText().charAt(0);
            num1 = result;
            first = "";
        }
    }
    
    public void handleClickEqual(ActionEvent actionEvent){
        if(!status){
            num1 = Double.parseDouble(ans.getText());
            ans.setText(String.valueOf(num1));
            status = false;
            first = "";
        }
        else{
            num2 = Double.parseDouble(ans.getText());
            if(two == '+'){
                result = num1 + num2;
            }
            if(two == '-'){
                result = num1 - num2;
            }
            if(two == '/'){
                result = num1 / num2;
            }
            if(two == 'x'){
                result = num1 * num2;
            }
            if(two == '%') {
            	result = num1 % num2;
            }
            String temp = new DecimalFormat ("#.####").format(result);
            ans.setText(temp);
            status = false;
            first = "";
        }
    }
    
    public void handleClickClear(ActionEvent actionEvent){
        status = false;
        num1 = 0;
        num2 = 0;
        result = 0;
        first = "";
        ans.setText("");
    }
    
    public void handleClickBack(ActionEvent actionEvent) {
    	status = false;
        num1 = 0;
        num2 = 0;
        result = 0;
        first = "";
        ans.setText("");
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(mainMenu);
	}
}

