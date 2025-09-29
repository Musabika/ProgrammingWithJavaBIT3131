package com.form;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;
import com.util.DB;

// Fidele MUSABIKA 223003195
// NISHIMWE SEZERANO Belyse 223010486
// MUJAWIMANA Claudine 223011219
// MUHAYIPUNDU Charlenne 223003942
// MUKAMA UYISENGA lea 223018803
 



public class UserPanel extends JPanel implements ActionListener {
	
	//components 

	JTextField idTxt = new JTextField();
	JTextField nameTxt = new JTextField();
	JTextField phoneTxt = new JTextField();
	JPasswordField passTxt = new JPasswordField();
	JTextField emailTxt = new JTextField();
	JTextField roleTxt = new JTextField();

	JPasswordField passTxf = new JPasswordField();
	
	JButton addBtn = new JButton ("Add"),
			updateBtn = new JButton ("Update"),
			deleteBtn = new JButton ("Delete"),
			loadBtn = new JButton ("Load");
	
	JTable table;
	DefaultTableModel model;
	
	//constructor
	
	public UserPanel(){
		
		setLayout(null);
		String [] labels = {"ID","UserName","Password","Phone","Email","Role"};
		String [] cols = {"UserId","userName","password","phone","email","role"};
		
		model = new DefaultTableModel(labels,0);
		table = new JTable(model);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(20, 200, 800, 300);
		int y = 20;

		addField("ID",idTxt,y);
		y+=30;
		addField("UserName",nameTxt,y);
		y+=30;
		addField("Password",passTxt,y);
		y+=30;
		addField("Phone",phoneTxt,y);
		y+=30;
		addField("Email",emailTxt,y);
		y+=30;
		addField("Role",roleTxt,y);
		
		addButtons();
		add(sp);
		
		
	}
	private void addButtons(){
		addBtn.setBounds(300, 20, 100, 30);
		updateBtn.setBounds(300, 60, 100, 30);
		deleteBtn.setBounds(300, 100, 100, 30);
		loadBtn.setBounds(300, 140, 100, 30);

		add(addBtn);
		add(updateBtn);
		add(deleteBtn);
		add(loadBtn);

		addBtn.addActionListener(this);	
		updateBtn.addActionListener(this);	
		deleteBtn.addActionListener(this);	
		loadBtn.addActionListener(this);		
		
		
	}

	


	private void addField(String lbl, JTextField txt, int y) {
		JLabel l = new JLabel (lbl);
		l.setBounds(20, y, 80, 25);
		txt.setBounds(100, y, 150, 25);
		add(l);
		add(txt);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try(Connection con = DB.getConnection()){
			String sql = null;
			if(e.getSource()==addBtn){
				 sql= "INSERT INTO user (username,password,phone,email,role) VALUES(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, nameTxt.getText());

				ps.setString(2, new String(passTxt.getPassword()));

				ps.setString(3, phoneTxt.getText());

				ps.setString(4, emailTxt.getText());

				ps.setString(5, roleTxt.getText());
				ps.executeUpdate();
				
			}
			else if(e.getSource()==updateBtn){
				sql = "UPDATE user SET username =?, password = ?,phone = ?,email = ?,role = ? WHERE userid = ?"; 
				
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, nameTxt.getText());

				ps.setString(2, new String(passTxt.getPassword()));

				ps.setString(3, phoneTxt.getText());

				ps.setString(4, emailTxt.getText());

				ps.setString(5, roleTxt.getText());
				

				ps.setInt(6, Integer.parseInt(idTxt.getText()));
				
				ps.executeUpdate();
			
			}else if(e.getSource()==deleteBtn){
				sql = "DELETE FROM user WHERE userid = ?"; 
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(idTxt.getText()));			
				ps.executeUpdate();
			}else if(e.getSource()==loadBtn){
				
				model.setRowCount(0);
				sql = "SELECT *  FROM user "; PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = con.createStatement().executeQuery(sql);	
				while(rs.next()){
					model.addRow(new Object[]{
							rs.getInt("UserId"),
							rs.getString("UserName"),
							rs.getString("password"),
							rs.getString("phone"),
							rs.getString("role"),
							
					});
					
				}
			}
			
			
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}

}
