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


//Group Members 

//Fidele MUSABIKA 223003195
//UMURERWA Aline Carine 223010696
//TUYIKUNDE Rebecca 223010994


public class CustomersPanel extends JPanel implements ActionListener {
	
	//components 

		JTextField CustomerIDTxt = new JTextField();
		
		JTextField FullNameTxt = new JTextField();
		JTextField ContactTxt = new JTextField();
		JTextField TypeTxt = new JTextField();

		
		JButton addBtn = new JButton ("Add"),
				updateBtn = new JButton ("Update"),
				deleteBtn = new JButton ("Delete"),
				loadBtn = new JButton ("Load");
		
		JTable table;
		DefaultTableModel model;
		
		//Constructor
		
		public CustomersPanel() {
			
			setLayout(null);
	
			String [] labels = {"Customer ID","Full Names","Contact","Type"};
			String [] cols = {"CustomerID","FullName","Contact","Type"};
			
			model = new DefaultTableModel(labels,0);
			table = new JTable(model);
			
			JScrollPane sp = new JScrollPane(table);
			sp.setBounds(20, 200, 800, 300);
			int y = 20;
			
	
			addField("Id",CustomerIDTxt,y);
			y+=30;
			addField("Full Names",FullNameTxt,y);
			y+=30;
			addField("Contact",ContactTxt,y);
			y+=30;
			addField("Type",TypeTxt,y); 
			
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
				 sql= "INSERT INTO customer (FullName,Contact,Type) VALUES(?,?,?)";
				 
				PreparedStatement ps = con.prepareStatement(sql);
				

				//ps.setString(1, CustomerIDTxt.getText());

				ps.setString(1, FullNameTxt.getText());
				
				ps.setString(2, ContactTxt.getText());
				
				ps.setString(3, TypeTxt.getText());
				
				ps.executeUpdate();
				
			}
			else if(e.getSource()==updateBtn){ 
				sql = "UPDATE customer SET FullName =?, Contact = ?,Type = ? WHERE CustomerID  = ?"; 
				
				PreparedStatement ps = con.prepareStatement(sql);
				
				
				//ps.setString(1, CustomerIDTxt.getText());

				ps.setString(1, FullNameTxt.getText());

				ps.setString(2, ContactTxt.getText());
				
				ps.setString(3, TypeTxt.getText());
				
				ps.setInt(4, Integer.parseInt(CustomerIDTxt.getText()));
				
			
				ps.executeUpdate();
			
			}
			else if(e.getSource()==deleteBtn){
				sql = "DELETE FROM customer WHERE CustomerID = ?"; 
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(CustomerIDTxt.getText()));			
				ps.executeUpdate();
			}
			else if(e.getSource()==loadBtn){
				
				model.setRowCount(0);
				sql = "SELECT *  FROM customer "; PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = con.createStatement().executeQuery(sql);	
				while(rs.next()){
					model.addRow(new Object[]{
							rs.getInt("CustomerID"),
							rs.getString("FullName"),
							rs.getString("Contact"),
							rs.getString("Type"),
							
					});
					
				}
			}
			
			
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}

}

	

