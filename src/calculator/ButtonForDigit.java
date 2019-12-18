package calculator;

import javax.swing.*;

public class ButtonForDigit extends JButton {
	int number = 0;
	ButtonForDigit(){
		super(" ");
	}
	
	ButtonForDigit(int number){
		super(Integer.toString(number));
		this.number = number;
	}
	
	void DoTask() {
		if(Calculator.currentState!='O') {
			Calculator.math_expression+=number;
			Calculator.screenNumber+=number;
			For_Gui.textscreen.setText(Calculator.screenNumber);
		}
		else {
			Calculator.screenNumber = String.valueOf(number);
		}
		Calculator.currentState = (char)number;
	}

}
