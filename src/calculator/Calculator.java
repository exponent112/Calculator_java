package calculator;


public class Calculator {
		public static String math_expression = "0"; //수식 저장
		public static char currentState; //숫자,연산기호, 소수점,
		
		public static double Num1 = 0;
		public static double Num2 = 0;
		public static double Num3 = 0;
		
		public static char Op1 = 0;
		public static char Op2 = 0;
		public static char Op3 = 0;
		
		public static String screenNumber="";
		public static boolean haveDot = false;
		
		public static int Op1_digit = 0;
		public static int Op2_digit = 0;
		public static int Op3_digit = 0;
			
		public static int start = 1;
		public static boolean CalculT = false;
		
		public static void main (String[] args) {
			For_Gui gui_test = new For_Gui();
			gui_test.createFrame();
		}	

}
