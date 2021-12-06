package application;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ageCalculatorController {
	
	private Scene mainMenu;
	
	public void setScene(Scene scene) {
		mainMenu = scene;
	}
	
	@FXML
	public DatePicker birth;
	public DatePicker today;
	public Label err;
	public Label years;
	public Label monthAndDays;
	public Label nextBirthdayDay;
	public Label nextBirthdayMonthsAndDays;
	public Label sumYears;
	public Label sumMonths;
	public Label sumWeeks;
	public Label sumDays;
	public Label sumHours;
	public Label sumMinutes;
	
	public void handleClickCalculate(ActionEvent actionEvent) {
		try {
			LocalDate birthDate = birth.getValue();
			LocalDate todayDate = today.getValue();
			Period period = Period.between(birthDate, todayDate);
			if(period.getDays() < 0) {
				err.setText("Invalid Inputs!");
				return;
			}
			
			//Displaying results in age portion
			years.setText(String.format("%d",period.getYears()));
			String m = String.format("%d", period.getMonths());
			String d = String.format("%d", period.getDays());
			String toDisplay = m + " months | " + d + " days";
			monthAndDays.setText(toDisplay);
			
			//Displaying results in next birthday portion
			
			LocalDate nextBirthDate = birthDate;
			nextBirthDate = nextBirthDate.plusYears(period.getYears() + 1);
			Period period1 = Period.between(todayDate, nextBirthDate);
			String m1 = String.format("%d", period1.getMonths());
			String d1 = String.format("%d", period1.getDays());
			String toDisplay1 = m1 + " months | " + d1 + " days";
			nextBirthdayMonthsAndDays.setText(toDisplay1);	
			DayOfWeek dayOfWeek = nextBirthDate.getDayOfWeek();
			String str = dayOfWeek.toString();
			String str1 = "";
			str1 = str1 + str.charAt(0);
			for(int i = 1; i < str.length(); i++) {
				str1 = str1 + Character.toLowerCase(str.charAt(i));
			}
			nextBirthdayDay.setText(str1);
			
			//Displaying results in summary portion
			sumYears.setText(String.format("%d", period.getYears()));
			sumMonths.setText(String.format("%d", (period.getYears() * 12) + period.getMonths()));
			sumWeeks.setText(String.format("%d", (ChronoUnit.DAYS.between(birthDate, todayDate) / 7)));
			sumDays.setText(String.format("%d", ChronoUnit.DAYS.between(birthDate, todayDate)));
			sumHours.setText(String.format("%d",ChronoUnit.DAYS.between(birthDate, todayDate) * 24));
			sumMinutes.setText(String.format("%d",ChronoUnit.DAYS.between(birthDate, todayDate) * 24 * 60));
			
		}catch(Exception e) {
			e.printStackTrace();
			err.setText("Invalid Input!");
		}
	}
	
	public void handleClickBack(ActionEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(mainMenu);
	}
	
}
