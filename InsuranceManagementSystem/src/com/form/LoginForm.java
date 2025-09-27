package com.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import com.util.DB;


//Group Members 

//Fidele MUSABIKA 223003195
//UMURERWA Aline Carine 223010696
//TUYIKUNDE Rebecca 223010994


public class LoginForm extends JFrame implements ActionListener{
	JTextField userTxt=new JTextField("Enter username");
	JPasswordField passTxt=new JPasswordField("Password");
	JButton loginbtn=new JButton("Login");

	//Constructor
	
	public  LoginForm(){

		setTitle("Login Form");
		setBounds(100,100,300,200);
		setLayout(null);

		userTxt.setBounds(50,30,120,25);
		passTxt.setBounds(50,70,120,25);

		loginbtn.setBounds(30,120,200,30);

		add(userTxt);
		add(passTxt);
		add(loginbtn);

		loginbtn.addActionListener(this);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	public void actionPerformed(ActionEvent e) {

		try(Connection con=DB.getConnection()){
			String sql="Select * FROM users WHERE Name=? AND PasswordHash= ?";
			PreparedStatement ps=con.prepareCall(sql);
			ps.setString(1,userTxt.getText());
			ps.setString(2, new String(passTxt.getPassword()));
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String role=rs.getString("Role");
				dispose();
				new IMS(role, rs.getInt("userID"));

			}
			else{
				JOptionPane.showMessageDialog(this,"Invalid Login");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

