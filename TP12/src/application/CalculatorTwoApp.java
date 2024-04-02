package application;


import javafx.application.Application; 
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CalculatorTwoApp extends Application {
	TextField valueField, answerField; RadioButton[]buttons;
	public void start(Stage primaryStage) {
		Pane aPane = new Pane();
		// Add the value label and text field
		Label label = new Label(" donner X:");
		label.relocate(10,10);
		label.setPrefSize(100, 30);
		aPane.getChildren().add(label);
		valueField = new TextField();
		valueField.relocate(80,10);
		valueField.setPrefSize(140, 30);
		aPane.getChildren().add(valueField);
		//Add the "operation type" radio buttons to the window 
		//and to a ButtonGroup so that one is on at a time
		label = new Label("Operation:");
		label.relocate(10,55);
		label.setPrefSize(100, 30);
		aPane.getChildren().add(label);
		ToggleGroup operations = new ToggleGroup(); buttons = new RadioButton[4];
		String[] buttonLabels = {"X + X", "X * X", "X ^ 0.5", "1 / X"}; for (int i=0; i<4; i++) {
			buttons[i] = new RadioButton(buttonLabels[i]);
			buttons[i].relocate(80, 60 + i*20);
			buttons[i].setPrefSize(150, 20);
			aPane.getChildren().add(buttons[i]);
			buttons[i].setToggleGroup(operations);
			buttons[i].setOnAction(new EventHandler<ActionEvent>() {
				//This is the single event handler for all of the radio buttons
				public void handle(ActionEvent event) {
					if (!valueField.getText().matches("[-,+,0-9]+")) {
						answerField.setText("Entrée pas valide"); 
						return; 
					}
					int value = Integer.parseInt(valueField.getText());
					//Find the number of the button that was clicked
					int buttonNumber = 0;
					for (buttonNumber=0; buttonNumber<4; buttonNumber++) { 
						if (buttons[buttonNumber] == event.getSource())
						break; 
						}
					//Perform the calculation
					double result=0;
					switch (buttonNumber) {
					case 0: result = value + value; break;
					case 1: result = value * value; break;
					case 2: result = Math.sqrt(value); break;
					case 3: result = 1 / (double)value; break;
					}
					//Show the answer
					answerField.setText("" + result);
					}
				});
			}
		//Add the answer label and text field
		label = new Label("Réponse:");
		label.relocate(10,150); label.setPrefSize(100, 30);
		aPane.getChildren().add(label);
		answerField = new TextField();
		answerField.relocate(80,150);
		answerField.setPrefSize(140, 30);
		answerField.setEditable(false);
		aPane.getChildren().add(answerField);
		primaryStage.setTitle("Calc 2");
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(aPane, 220,180));
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args); 
		}
	}
