package calculator;

import javax.swing.JButton;

public class For_operator  extends JButton {
	char operator;
	int number_forP;
	
	For_operator(char operator){
		super(Character.toString(operator));
		this.operator = operator;
		if(operator == '+'||operator == '-') number_forP = 1; //case '+' '-' 2
 		else if(operator == '*'||operator == '/') number_forP = 2; //case '*' '/' 2
		else number_forP = 0; //case '=' 0
	}
	
	boolean alarm (char Op1 , double num2) {
		if(Op1 == '/'&& num2 == 0.0) return true;
		else return false;
	}
	
	void DoForEqualTask()
	{
		
	}
	void DoTask() {
		Calculator c = new Calculator();
		c.currentState = 'O';
		c.haveDot = false;
		switch(c.start) {
			case 1: c.Num1 = Float.valueOf(Calculator.screenNumber); //when input is first operator, save Num1
					c.Op1 = operator;
					System.out.println("Num1 = "+c.Num1); //print Num1
					System.out.println("Op1 = "+c.Op1); //print Op1
					c.Op1 = operator;
					c.Op1_digit = number_forP;
					break;
			case 2: c.Num2 = Float.valueOf(Calculator.screenNumber); //when input is second operator, save Num2
					c.Op2 = operator;
					System.out.println("Num2 = "+c.Num2); //print Num2
					System.out.println("Op1 = "+c.Op2); //print Op2
					c.Op2 = operator;
					c.Op2_digit = number_forP;
					break;
			case 3: c.Num3 = Float.valueOf(Calculator.screenNumber); //when input is third operator, save Num2
					c.Op3 = operator;
					System.out.println("Num3 = "+c.Num3); //print Num3
					System.out.println("Op3 = "+c.Op3); //print Op3
					c.Op3 = operator;
					c.Op3_digit = number_forP;
					break;	
		}
		
		if(c.start == 2 && c.Op1_digit >= c.Op2_digit) {
			if(alarm (c.Op1 , c.Num2)) {
				For_Gui.textscreen.setText("0으로 나눌 수 없습니다.");
				return;
			}
			c.Num1 = DoFEqual(c.Num1, c.Op1  ,c.Num2);
			System.out.println("case1 = "+c.Num1 + c.Op1 +c.Num2); //
			Calculator.screenNumber = String.valueOf(c.Num1);
			For_Gui.textscreen.setText(Calculator.screenNumber);
			c.Num2 = 0.0;
			c.Op1 = c.Op2;
			c.Op1_digit = c.Op2_digit;
			c.start = 1;
		}
		if(c.start == 3) {
			double temp = 0.0;
			if(alarm (c.Op2 , c.Num3)) {
				For_Gui.textscreen.setText("0으로 나눌 수 없습니다.");
				return;
			}
			temp = DoFEqual(c.Num2, c.Op2  ,c.Num3);
			System.out.println("temp = "+c.Num2 + c.Op2 +c.Num3 +"=" + temp);
			if(alarm (c.Op1 , temp)) {
				For_Gui.textscreen.setText("0으로 나눌 수 없습니다.");
				return;
			}
			if(c.Op1_digit>=c.Op3_digit) {
				c.Num1 = DoFEqual(c.Num1, c.Op1  ,temp);
				System.out.println("output = "+c.Num1 + c.Op1 + temp);
				c.screenNumber = String.valueOf(c.Num1);
				c.Num2 = 0.0;
				c.Num3 = 0.0;
				For_Gui.textscreen.setText(Calculator.screenNumber);
				c.Op1 = c.Op3;
				c.Op1_digit = c.Op3_digit;
				c.start = 1;
			}
			else{
				c.Num2 = temp;
				c.screenNumber = String.valueOf(c.Num2);
				c.Op2 = c.Op3;
				For_Gui.textscreen.setText(c.screenNumber);
				c.Op2_digit = c.Op3_digit;
				c.start = 2;
			} 
		}
		c.start++;
	}
	
	
	static double DoFEqual(double num1, char Op  ,double num2) {
		double output = 0.0;
		if(Op == '+') return num1 + num2;
		else if(Op == '-') return num1 - num2;
		else if(Op == '*') return num1 * num2;
		else return num1 / num2;
	}
	
	void DoTaskfordot() {
		Calculator.currentState = '.';
		if(Calculator.haveDot == false) {
			Calculator.haveDot = true;
			Calculator.screenNumber +='.';
			Calculator.math_expression+='.';
		}
		For_Gui.textscreen.setText(Calculator.screenNumber);
	}
}
