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

public class AssetPanel extends JPanel implements ActionListener {
	
	//components 

		JTextField assetIdTxt = new JTextField();
		JTextField typeTxt = new JTextField();
		JTextField valueTxt = new JTextField();
		JTextField registrationNoTxt = new JTextField();
		JTextField descriptionTxt = new JTextField();
		JTextField 	CustomerIDTxt = new JTextField();

		
		JButton addBtn = new JButton ("Add"),
				updateBtn = new JButton ("Update"),
				deleteBtn = new JButton ("Delete"),
				loadBtn = new JButton ("Load");
		
		JTable table;
		DefaultTableModel model;
		
		//Constructor
		
		public AssetPanel(){
			
			setLayout(null);
	
			String [] labels = {"assetId","typeName","value","registrationNo","description","CustomerID"};
			String [] cols = {"AssetID","Type","Value","RegistrationNo","Description","CustomerID"};
			
			model = new DefaultTableModel(labels,0);
			table = new JTable(model);
			
			JScrollPane sp = new JScrollPane(table);
			sp.setBounds(20, 200, 800, 300);
			int y = 20;

			addField("Id",assetIdTxt,y);
			y+=30;
			addField("Type",typeTxt,y);
			y+=30;
			addField("Value",valueTxt,y);
			y+=30;
			addField("Registration No",registrationNoTxt,y);
			y+=30;
			addField("Description",descriptionTxt,y);
			y+=30;
			addField("Customer Id",CustomerIDTxt,y);
			
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
			l.setBounds(10, y, 100, 25);
			txt.setBounds(100, y, 150, 25);
			add(l);
			add(txt);
			
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		try(Connection con = DB.getConnection()){
			String sql = null;
			if(e.getSource()==addBtn){
				 sql= "INSERT INTO asset (Type,Value,RegistrationNo,Description,CustomerID) VALUES(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				


				//ps.setString(1, assetIdTxt.getText());

				ps.setString(1, typeTxt.getText());
				
				ps.setString(2, valueTxt.getText());
				
				ps.setString(3, registrationNoTxt.getText());
				
				ps.setString(4, descriptionTxt.getText());

				ps.setString(5, CustomerIDTxt.getText());


				ps.executeUpdate();
				
			}
			else if(e.getSource()==updateBtn){
				sql = "UPDATE asset SET Type =?, Value = ?,registrationNo = ?,Description = ?,CustomerID = ? WHERE AssetID = ?"; 
				
				PreparedStatement ps = con.prepareStatement(sql);
				
				
				ps.setString(1, typeTxt.getText());

				ps.setString(2, valueTxt.getText());

				ps.setString(3, registrationNoTxt.getText());

				ps.setString(4, descriptionTxt.getText());

				ps.setString(5, CustomerIDTxt.getText());
				
				ps.setInt(6, Integer.parseInt(assetIdTxt.getText()));
				
				ps.executeUpdate();
			
 			}
				else if(e.getSource()==deleteBtn){
				sql = "DELETE FROM users WHERE userID = ?"; 
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(assetIdTxt.getText()));			
				ps.executeUpdate();
			}
			else if(e.getSource()==loadBtn){
				
				model.setRowCount(0);
				sql = "SELECT *  FROM asset "; PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = con.createStatement().executeQuery(sql);	
				while(rs.next()){
					model.addRow(new Object[]{
							rs.getInt("AssetId"),
							rs.getString("Type"),
							rs.getString("Value"),
							rs.getString("RegistrationNo"),
							rs.getString("Description"),
							rs.getString("CustomerID"),
							
					});
					
				}
			}
			
			
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}

}

	

