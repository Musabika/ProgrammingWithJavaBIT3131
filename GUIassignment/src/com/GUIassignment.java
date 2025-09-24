package com;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIassignment implements ActionListener{
	
	//label declaration 
	
	JFrame frame;
	JLabel amountRequested =  new JLabel("Amount requested");
	JLabel Duration =  new JLabel("Duration(Year)");
	JLabel totalToReturn =  new JLabel("Total to Return");
	
	// text field area
	
	JTextField Artxt = new JTextField();
	JTextField Dur = new JTextField();
	JTextField Ttl = new JTextField();
	
	//buttons area
	
	JButton Calculate = new JButton( " Calculate ");
	
	public GUIassignment(){
		
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		addActionEvent();
	}

	//setting frame 



	private void createWindow() {
		
		frame = new JFrame();
		
		frame.setTitle("=====Interest Rate Calculator======");
		frame.setBounds(10, 10, 380, 600);
		frame.getContentPane().setBackground(Color.blue);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	private void addComponentsToFrame() {
		//add 
		
	frame.add(amountRequested);
	frame.add(Duration);
	frame.add(totalToReturn);
	

	frame.add(Artxt);	
	frame.add(Dur);	
	frame.add(Ttl);	
		
	frame.add(Calculate);
	
	}

	
	private void setLocationAndSize() {
		amountRequested.setBounds(10, 10, 100, 30);
		Artxt.setBounds(120, 10, 100, 30);
		

		Duration.setBounds(10, 50, 100, 30);
		Dur.setBounds(120, 50, 100, 30);
		

		totalToReturn.setBounds(10, 100, 100, 30);
		Ttl.setBounds(120, 100, 100, 30);
		
		int x= 50,y= 150,w=150,h=40;
		Calculate.setBounds(x, y, w, h);
		

		
		
	}
	
	
	
	private void addActionEvent() {
		Calculate.addActionListener(this);

	}



	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== Calculate){
			int amount = Integer.parseInt(Artxt.getText());
			int dura = Integer.parseInt(Dur.getText());
			double interest = 0.006;
			double total = (amount * interest) + amount;
			
			Ttl.setText(String.valueOf(total));
			
		}
	
		else{
			System.out.println("please enter valid inputs");
		}
		
	}
	
}
