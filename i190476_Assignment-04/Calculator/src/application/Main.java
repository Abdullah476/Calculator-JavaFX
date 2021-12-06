package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

	 @Override
    public void start(Stage primaryStage) throws Exception {
        try {
        	//loading FXML files
        	FXMLLoader mainMenuLoader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        	Parent mainMenu = mainMenuLoader.load();
        	FXMLLoader ageCalculatorLoader = new FXMLLoader(getClass().getResource("ageCalculator.fxml"));
        	Parent ageCalculator = ageCalculatorLoader.load();
        	FXMLLoader bmiCalculatorLoader = new FXMLLoader(getClass().getResource("bmiCalculator.fxml"));
        	Parent bmiCalculator = bmiCalculatorLoader.load();
        	FXMLLoader calculatorLoader = new FXMLLoader(getClass().getResource("calculator.fxml"));
        	Parent calculator = calculatorLoader.load();
        	FXMLLoader currencyConvertorLoader = new FXMLLoader(getClass().getResource("currencyConvertorCalculator.fxml"));
        	Parent currencyConvertor = currencyConvertorLoader.load();
        	FXMLLoader discountCalculatorLoader = new FXMLLoader(getClass().getResource("discountCalculator.fxml"));
        	Parent discountCalculator = discountCalculatorLoader.load();
        	FXMLLoader investmentCalculatorLoader = new FXMLLoader(getClass().getResource("investmentCalculator.fxml"));
        	Parent investmentCalculator = investmentCalculatorLoader.load();
        	
        	//load up scenes from panes
        	Scene mainScene = new Scene(mainMenu, 300, 450);
        	Scene ageScene = new Scene(ageCalculator, 300, 450);
        	Scene bmiScene = new Scene(bmiCalculator, 300, 450);
        	Scene calculatorScene = new Scene(calculator, 300, 450);
        	Scene currencyScene = new Scene(currencyConvertor, 300, 450);
        	Scene discountScene = new Scene(discountCalculator, 300, 450);
        	Scene investmentScene = new Scene(investmentCalculator, 300, 450);
        	
        	//injecting scenes into controllers
        	mainMenuController mainCon = (mainMenuController) mainMenuLoader.getController();
        	mainCon.setAge(ageScene);
        	mainCon.setBmi(bmiScene);
        	mainCon.setCalculator(calculatorScene);
        	mainCon.setCurrency(currencyScene);
        	mainCon.setDisount(discountScene);
        	mainCon.setInvestment(investmentScene);
        	
        	ageCalculatorController ageCon = (ageCalculatorController) ageCalculatorLoader.getController();
        	ageCon.setScene(mainScene);
        	bmiCalculatorController bmiCon = (bmiCalculatorController) bmiCalculatorLoader.getController();
        	bmiCon.setScene(mainScene);
        	CalculatorController calCon = (CalculatorController) calculatorLoader.getController();
        	calCon.setScene(mainScene);
        	currencyConvertorCalculatorController currCon = (currencyConvertorCalculatorController) currencyConvertorLoader.getController();
        	currCon.setScene(mainScene);
        	discountCalculatorController disCon = (discountCalculatorController) discountCalculatorLoader.getController();
        	disCon.setScene(mainScene);
        	investmentCalculatorController invCon = (investmentCalculatorController) investmentCalculatorLoader.getController();
        	invCon.setScene(mainScene);
        	
        	//initial scene
        	primaryStage.setTitle("Super Calculator");
        	primaryStage.setScene(mainScene);
        	primaryStage.setResizable(false);
        	primaryStage.show();
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
