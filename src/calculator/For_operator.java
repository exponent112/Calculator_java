package calculator;

import javax.swing.JButton;
import java.lang.Math;

public class For_operator  extends JButton {
	private char operator;
	private int number_forP;
	private String forS = "";
	
	For_operator(char operator){
		super(Character.toString(operator));
		this.operator = operator;
		if(operator == '+'||operator == '-') number_forP = 1; //case '+' '-' 2
 		else if(operator == '*'||operator == '/') number_forP = 2; //case '*' '/' 2
		else number_forP = 0; //case '=' 0
	}
	
	For_operator(String ac){
		super(ac);
		forS = ac;
	}
	
	
	boolean alarm (char Op1 , double num2) {
		if(Op1 == '/'&& num2 == 0.0) return true;
		else return false;
	}
	
	protected void forClear () {
		Calculator c = new Calculator();
		c.currentState = '-'; //숫자,연산기호, 소수점
		c.Num1 = 0;
		c.Num2 = 0;
		c.Num3 = 0;
		c.Op1 = 0;
		c.Op2 = 0;
		c.Op3 = 0;
		c.screenNumber="0";
		c.haveDot = false;
		c.Op1_digit = 0;
		c.Op2_digit = 0;
		c.Op3_digit = 0;
		c.start = 1;
		c.CalculT = false;
		For_Gui.textscreen.setText(Calculator.screenNumber);
		return;
	}
	
	static void ForPow(String S) {
		//System.out.println("asd");
		String[] words = S.split("\\^");
		for(String wo: words) {
			System.out.println("asd");
			System.out.println(wo);
		}
		double temp = Math.pow(Double.valueOf(words[0]),Double.valueOf(words[1]));
		StringToInt(Calculator.screenNumber);
		Calculator.screenNumber = String.valueOf(temp);
	}
	
	protected void DoTask() {
		Calculator c = new Calculator();
		
		if(Calculator.screenNumber.contains("^")) {
			ForPow(Calculator.screenNumber);
		}
		
		c.currentState = 'O';
		c.haveDot = false;
		switch(c.start) {
			case 1: c.Num1 = Double.valueOf(Calculator.screenNumber); //when input is first operator, save Num1
					c.Op1 = operator;
					System.out.println("Num1 = "+c.Num1); //print Num1
					System.out.println("Op1 = "+c.Op1); //print Op1
					c.Op1 = operator;
					c.Op1_digit = number_forP;
					break;
			case 2: c.Num2 = Double.valueOf(Calculator.screenNumber); //when input is second operator, save Num2
					c.Op2 = operator;
					System.out.println("Num2 = "+c.Num2); //print Num2
					System.out.println("Op1 = "+c.Op2); //print Op2
					c.Op2 = operator;
					c.Op2_digit = number_forP;
					break;
			case 3: c.Num3 = Double.valueOf(Calculator.screenNumber); //when input is third operator, save Num2
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
			String str = String.valueOf(c.Num1);
			float s = Float.parseFloat(str);
			str = String.valueOf(s);
			System.out.println("case1 = "+ s + c.Op1 +c.Num2); //
			Calculator.screenNumber = str;
			StringToInt (c.screenNumber);
			System.out.println("NU"+Calculator.screenNumber);
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
				String str = String.valueOf(c.Num1);
				float s = Float.parseFloat(str);
				str = String.valueOf(s);
				Calculator.screenNumber = str;
				c.Num2 = 0.0;
				c.Num3 = 0.0;
				StringToInt (c.screenNumber);
				For_Gui.textscreen.setText(Calculator.screenNumber);
				c.Op1 = c.Op3;
				c.Op1_digit = c.Op3_digit;
				c.start = 1;
			}
			else{
				c.Num2 = temp;
				c.screenNumber = String.valueOf(c.Num2);
				c.Op2 = c.Op3;
				String str = String.valueOf(c.Num2);
				float s = Float.parseFloat(str);
				str = String.valueOf(s);
				Calculator.screenNumber = str;
				StringToInt (c.screenNumber);
				For_Gui.textscreen.setText(c.screenNumber);
				c.Op2_digit = c.Op3_digit;
				c.start = 2;
			} 
		}
		c.start++;
	}
	
	
	protected static void StringToInt (String S) {
		System.out.println(S.contains(".0"));
		if(S.contains(".0")) while(true) {
			if(S.endsWith(".0") ||S.endsWith(".") || S.endsWith("0") ) S = S.substring(0, S.length()-1);
			
			else break;
		}
		Calculator.screenNumber = S;
	}
	
	static void root() {
		Calculator.screenNumber = String.valueOf(Math.sqrt(Double.valueOf(Calculator.screenNumber))) ;
		StringToInt(Calculator.screenNumber);
		For_Gui.textscreen.setText(Calculator.screenNumber);
	}
	
	
	static void factorial() {
		if(Calculator.CalculT) For_Gui.textscreen.setText("factorial은 int만 가능합니다.");
		else {
			int temp = 1;
			for(int i = 1;i<=(int)(Double.parseDouble(Calculator.screenNumber));i++) {
				temp *=i;
				System.out.println(temp);
			}
			Calculator.screenNumber = String.valueOf(temp);
			StringToInt(Calculator.screenNumber);
			For_Gui.textscreen.setText(Calculator.screenNumber);
		}
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
		}
		For_Gui.textscreen.setText(Calculator.screenNumber);
	}
}
