package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class For_Gui extends Frame implements ActionListener {
	JFrame frame = new JFrame("calculator");
	JPanel jpanel = new JPanel();
	JPanel jpanel2 = new JPanel();
	ButtonForDigit[] buttons_fordigit = new ButtonForDigit[10];
	For_operator[] buttons_forOp = new For_operator[6];
	public static JLabel textscreen = new JLabel("0",Label.RIGHT);
	
	public void createFrame() {
		frame.getContentPane().setBackground(new java.awt.Color(167, 173, 186));
		Container container = frame.getContentPane();
		textscreen.setMinimumSize(new Dimension(250, 50));
		jpanel2.add(textscreen);
		frame.add(jpanel2,BorderLayout.NORTH);
		jpanel.setBackground(new java.awt.Color(218, 217, 255));
		
		for(int i = buttons_fordigit.length-1;i>=0;i--) {
			buttons_fordigit[i] = new ButtonForDigit(i);
			jpanel.add(buttons_fordigit[i]); //frmae.add(Component component)
			if((i-1) %3 == 0){
				switch(i) {
				case 7: buttons_forOp[0] = new For_operator('+');
						buttons_forOp[0].setFont(new Font("굴림",Font.ITALIC,20));
						jpanel.add(buttons_forOp[0]);
						break;
				case 4: buttons_forOp[1] = new For_operator('-');
						buttons_forOp[1].setFont(new Font("굴림",Font.ITALIC,20));
						jpanel.add(buttons_forOp[1]);break;
				case 1: buttons_forOp[2] = new For_operator('*');
						buttons_forOp[2].setFont(new Font("굴림",Font.ITALIC,20));
						jpanel.add(buttons_forOp[2]);break;
				}
			}
		}		
		buttons_forOp[3] = new For_operator('.');
		buttons_forOp[4] = new For_operator('=');
		buttons_forOp[4].setFont(new Font("굴림",Font.ITALIC,20));
		buttons_forOp[5] = new For_operator('/');
		buttons_forOp[5].setFont(new Font("굴림",Font.ITALIC,20));
		for(int i = 3;i<6;i++) {
			jpanel.add(buttons_forOp[i]);
		}
		frame.add(jpanel);
		frame.setSize(350,240);
		frame.setVisible(true); 
		for(int i = buttons_fordigit.length-1;i>=0;i--) {
			buttons_fordigit[i].addActionListener(this);
			if(i<6)
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
			else if(i<6) {
				if(e.getSource().equals(buttons_forOp[i])) {
					if(i == 3){
						buttons_forOp[i].DoTaskfordot();
					}
					else {
						buttons_forOp[i].DoTask();
					}
				}
			}
		}
	}
}

