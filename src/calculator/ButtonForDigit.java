package calculator;

import javax.swing.*;

public class ButtonForDigit extends JButton {
	private int number = 0;
	ButtonForDigit(){
		super(" ");
	}
	
	ButtonForDigit(int number){
		super(Integer.toString(number));
		this.number = number;
	}
	
	void DoTask() {
		if(number == 0 && Calculator.screenNumber.equals("0")) return;
		if(Calculator.currentState!='O') {
			if(Calculator.screenNumber.equals("0")) Calculator.screenNumber = String.valueOf(number);
			else Calculator.screenNumber+=number;
			For_Gui.textscreen.setText(Calculator.screenNumber);
		}
		else {
			
			Calculator.screenNumber = String.valueOf(number);
		}
		Calculator.currentState = (char)number;
	}

}
