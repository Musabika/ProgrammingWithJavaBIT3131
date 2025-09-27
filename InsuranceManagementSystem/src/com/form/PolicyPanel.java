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

public class PolicyPanel extends JPanel implements ActionListener {
	
	//components 							

		JTextField PolicyIDTxt = new JTextField();
		JTextField PolicyNoTxt = new JTextField();
		JTextField StartDateTxt = new JTextField();
		JTextField EndDateTxt = new JTextField();
		JTextField PremiumAmountTxt = new JTextField();
		JTextField 	StatusTxt = new JTextField();
		JTextField CustomerIDTxt = new JTextField();
		JTextField 	AssetIDTxt = new JTextField();

		
		JButton addBtn = new JButton ("Add"),
				updateBtn = new JButton ("Update"),
				deleteBtn = new JButton ("Delete"),
				loadBtn = new JButton ("Load");
		
		JTable table;
		DefaultTableModel model;
		
		//Constructor
		
		public PolicyPanel(){
			
			setLayout(null);
	

			String [] labels = {"PolicyID","PolicyNo","StartDate","EndDate","PremiumAmount","Status","CustomerID","AssetID"};
			String [] cols = {"PolicyID","PolicyNo","StartDate","EndDate","PremiumAmount","Status","CustomerID","AssetID"};
			
			model = new DefaultTableModel(labels,0);
			table = new JTable(model);
			
			JScrollPane sp = new JScrollPane(table);
			sp.setBounds(20, 280, 800, 300);
			
			int y = 20;			

			addField("Policy ID",PolicyIDTxt,y);
			y+=30;
			addField("PolicyNo",PolicyNoTxt,y);
			y+=30;
			addField("Start Date",StartDateTxt,y);
			y+=30;
			addField("EndDate",EndDateTxt,y);
			y+=30;
			addField("Premium Amount",PremiumAmountTxt,y);
			y+=30;
			addField("Status",StatusTxt,y);
			y+=30;
			addField("Customer ID",CustomerIDTxt,y);
			y+=30;
			addField("Asset ID",AssetIDTxt,y);
			
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
			l.setBounds(20, y, 180, 25);
			txt.setBounds(130, y, 150, 25);
			add(l);
			add(txt);
			
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		try(Connection con = DB.getConnection()){
			String sql = null;
			if(e.getSource()==addBtn){
				 sql= "INSERT INTO policy (PolicyNo,StartDate,EndDate,PremiumAmount,Status,CustomerID,AssetID) VALUES(?,?,?,?,?,?,?)";
				
				PreparedStatement ps = con.prepareStatement(sql);

				//ps.setString(1, assetIdTxt.getText());

											

				ps.setString(1, PolicyNoTxt.getText());
				
				ps.setString(2, StartDateTxt.getText());
				
				ps.setString(3, EndDateTxt.getText());

				ps.setString(4, PremiumAmountTxt.getText());

				ps.setString(5, StatusTxt.getText());
				
				ps.setString(6, CustomerIDTxt.getText());

				ps.setString(7, AssetIDTxt.getText());


				ps.executeUpdate();
				
			}
			else if(e.getSource()==updateBtn){
				sql = "UPDATE policy SET PolicyNo =?, StartDate = ?,EndDate = ?,PremiumAmount = ?,Status = ?, CustomerID = ?,AssetID = ? WHERE PolicyID = ?"; 
				
				PreparedStatement ps = con.prepareStatement(sql);
				
				
				ps.setString(1, PolicyNoTxt.getText());

				ps.setString(2, StartDateTxt.getText());

				ps.setString(3, EndDateTxt.getText());

				ps.setString(4, PremiumAmountTxt.getText());

				ps.setString(5, StatusTxt.getText());

				ps.setString(6, CustomerIDTxt.getText());

				ps.setString(7, AssetIDTxt.getText());
				
				ps.setInt(8, Integer.parseInt(PolicyIDTxt.getText()));
				
				ps.executeUpdate();
			
 			}
				else if(e.getSource()==deleteBtn){
				sql = "DELETE FROM policy WHERE PolicyID = ?"; 
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(PolicyIDTxt.getText()));			
				ps.executeUpdate();
			}
			else if(e.getSource()==loadBtn){
				
				model.setRowCount(0);
				sql = "SELECT *  FROM policy "; PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = con.createStatement().executeQuery(sql);	
				while(rs.next()){
					model.addRow(new Object[]{

							rs.getInt("PolicyID"),
							rs.getString("PolicyNo"),
							rs.getString("StartDate"),
							rs.getString("EndDate"),
							rs.getString("PremiumAmount"),
							rs.getString("Status"),
							rs.getString("CustomerID"),
							rs.getString("AssetID"),
							
					});
					
				}
			}
			
			
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}

}

	

