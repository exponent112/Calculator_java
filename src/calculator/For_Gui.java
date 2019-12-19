package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class For_Gui extends Frame implements ActionListener {
	JFrame frame = new JFrame("calculator");
	JPanel jpanel = new JPanel();
	JPanel jpanel2 = new JPanel();

	ButtonForDigit[] buttons_fordigit = new ButtonForDigit[10];
	For_operator[] buttons_forOp = new For_operator[10];
	public static JLabel textscreen = new JLabel("0",Label.RIGHT);
	
	public void createFrame() {
		frame.getContentPane().setBackground(new java.awt.Color(167, 173, 186));
		Container container = frame.getContentPane();
		textscreen.setMinimumSize(new Dimension(250, 50));
		jpanel2.add(textscreen);
		frame.add(jpanel2,BorderLayout.NORTH);
		
		jpanel.setBackground(new java.awt.Color(168, 180, 240));
		
		for(int i = buttons_fordigit.length-1;i>=0;i--) {
			buttons_fordigit[i] = new ButtonForDigit(i);
			buttons_fordigit[i].setBorder(new RoundedBorder(10));
			jpanel.add(buttons_fordigit[i]); //frmae.add(Component component)
			if((i-1) %3 == 0){
				switch(i) {
				case 7: buttons_forOp[0] = new For_operator('+');
				buttons_forOp[0].setBorder(new RoundedBorder(10));
						buttons_forOp[0].setFont(new Font("굴림",Font.ITALIC,15));
						buttons_fordigit[i].setBorder(new RoundedBorder(10));
						jpanel.add(buttons_forOp[0]);
						
						break;
				case 4: buttons_forOp[1] = new For_operator('-');
						buttons_forOp[1].setFont(new Font("굴림",Font.ITALIC,15));
						buttons_forOp[1].setBorder(new RoundedBorder(10));
						jpanel.add(buttons_forOp[1]);break;
				case 1: buttons_forOp[2] = new For_operator('*');
						buttons_forOp[2].setFont(new Font("굴림",Font.ITALIC,15));
						buttons_forOp[2].setBorder(new RoundedBorder(10));
						jpanel.add(buttons_forOp[2]);break;
				}
			}
		}		
		buttons_forOp[3] = new For_operator('.');
		buttons_forOp[3].setBorder(new RoundedBorder(10));
		buttons_forOp[4] = new For_operator('=');
		buttons_forOp[4].setFont(new Font("굴림",Font.ITALIC,15));
		buttons_forOp[4].setBorder(new RoundedBorder(10));
		
		
		buttons_forOp[5] = new For_operator('/');
		buttons_forOp[5].setBorder(new RoundedBorder(10));
		buttons_forOp[5].setFont(new Font("굴림",Font.ITALIC,15));
		
		buttons_forOp[6] = new For_operator('√');
		buttons_forOp[6].setBorder(new RoundedBorder(10));
		buttons_forOp[6].setFont(new Font("굴림",Font.ITALIC,15));
		
		buttons_forOp[7] = new For_operator('!');
		buttons_forOp[7].setBorder(new RoundedBorder(10));
		buttons_forOp[7].setFont(new Font("굴림",Font.ITALIC,15));
		
		buttons_forOp[8] = new For_operator('^');
		buttons_forOp[8].setBorder(new RoundedBorder(10));
		buttons_forOp[8].setFont(new Font("굴림",Font.ITALIC,15));
		
		buttons_forOp[9] = new For_operator("A/C");
		buttons_forOp[9].setBorder(new RoundedBorder(10));
		buttons_forOp[9].setForeground(Color.RED);
		buttons_forOp[9].setFont(new Font("굴림",Font.ITALIC,15));
		for(int i = 3;i<10;i++) {
			jpanel.add(buttons_forOp[i]);
		}
		
		frame.add(jpanel);
		frame.setSize(165,300);
		frame.setVisible(true);
		
		for(int i = buttons_fordigit.length-1;i>=0;i--) {
			buttons_fordigit[i].addActionListener(this);
			buttons_forOp[i].addActionListener(this);
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = buttons_fordigit.length-1;i>=0;i--) {
			if(e.getSource().equals(buttons_fordigit[i]))
				buttons_fordigit[i].DoTask();
			else if(e.getSource().equals(buttons_forOp[i])) {
					if(i == 3){
						buttons_forOp[i].DoTaskfordot();
					}
					else if(i == 6) {
						buttons_forOp[i].root();
					}
					else if(i == 7) {
						buttons_forOp[i].factorial();
					}
					else if(i == 8 ) {
						Calculator.screenNumber+="^";
						For_Gui.textscreen.setText(Calculator.screenNumber);
					}
					else if(i == 9) {
						buttons_forOp[i].forClear();
					}
					else {
						buttons_forOp[i].DoTask();
					}
				}
		}
	}
}

