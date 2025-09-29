package com.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import com.util.DB;

public class LogninForm extends JFrame implements ActionListener{
	JTextField userTxt=new JTextField("Enter username");
	JPasswordField passTxt=new JPasswordField("Password");
	JButton loginbtn=new JButton("Login");
	JButton cancelbtn=new JButton("Cancel");

	//Constructor
	public  LogninForm(){

		setTitle("Login Form");
		setBounds(100,100,300,200);
		setLayout(null);

		userTxt.setBounds(50,30,120,25);
		passTxt.setBounds(50,70,120,25);

		loginbtn.setBounds(30,120,100,30);
		cancelbtn.setBounds(150,120,100,30);

		add(userTxt);
		add(passTxt);
		add(loginbtn);
		add(cancelbtn);

		loginbtn.addActionListener(this);
		cancelbtn.addActionListener(this);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	public void actionPerformed(ActionEvent e) {

		try(Connection con=DB.getConnection()){
			String sql="Select * FROM user WHERE username=? AND password = ?";
			PreparedStatement ps=con.prepareCall(sql);
			ps.setString(1,userTxt.getText());
			ps.setString(2, new String(passTxt.getPassword()));
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String role=rs.getString("role");
				dispose();
				new SMIS(role, rs.getInt("userid"));

			}
			else{
				JOptionPane.showMessageDialog(this,"Invalid Login");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

