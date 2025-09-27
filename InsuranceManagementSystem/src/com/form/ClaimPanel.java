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

public class ClaimPanel extends JPanel implements ActionListener {
	
	//components 							
						
		JTextField ClaimIDTxt = new JTextField();
		JTextField ClaimDateTxt = new JTextField();
		JTextField ClaimAmountTxt = new JTextField();
		JTextField StatusTxt = new JTextField();
		JTextField PolicyIDTxt = new JTextField();
		
		JButton addBtn = new JButton ("Add"),
				updateBtn = new JButton ("Update"),
				deleteBtn = new JButton ("Delete"),
				loadBtn = new JButton ("Load");
		
		JTable table;
		DefaultTableModel model;
		
		//Constructor
		
		public ClaimPanel(){
			
			setLayout(null);
	

			String [] labels = {"ClaimID","ClaimDate","ClaimAmount","Status","PolicyID"};
			String [] cols = {"ClaimID","ClaimDate","ClaimAmount","Status","PolicyID"};
			
			model = new DefaultTableModel(labels,0);
			table = new JTable(model);
			
			JScrollPane sp = new JScrollPane(table);
			sp.setBounds(20, 200, 800, 300);
			
			int y = 20;		
			
			addField("ClaimID",ClaimIDTxt,y);
			y+=30;
			addField("ClaimDate",ClaimDateTxt,y);
			y+=30;
			addField("ClaimAmount",ClaimAmountTxt,y);
			y+=30;
			addField("Status",StatusTxt,y);
			y+=30;
			addField("PolicyID",PolicyIDTxt,y);
			
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
				 sql= "INSERT INTO claim (ClaimDate,ClaimAmount,Status,PolicyID) VALUES(?,?,?,?)";
				
				PreparedStatement ps = con.prepareStatement(sql);

				//ps.setString(1, assetIdTxt.getText());

				//ClaimID								

				ps.setString(1, ClaimDateTxt.getText());
				
				ps.setString(2, ClaimAmountTxt.getText());
				
				ps.setString(3, StatusTxt.getText());

				ps.setString(4, PolicyIDTxt.getText());



				ps.executeUpdate();
				
			}
			else if(e.getSource()==updateBtn){
				sql = "UPDATE claim SET ClaimDate =?, ClaimAmount = ?,Status = ?,PolicyID = ? WHERE ClaimID = ?"; 
									
				PreparedStatement ps = con.prepareStatement(sql);
				
									
				
				ps.setString(1, ClaimDateTxt.getText());

				ps.setString(2, ClaimAmountTxt.getText());

				ps.setString(3, StatusTxt.getText());

				ps.setString(4, PolicyIDTxt.getText());

				ps.setInt(5, Integer.parseInt(ClaimIDTxt.getText()));
				
				ps.executeUpdate();
			
 			}
				else if(e.getSource()==deleteBtn){
				sql = "DELETE FROM claim WHERE PolicyID = ?"; 
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(ClaimIDTxt.getText()));			
				ps.executeUpdate();
			}
			else if(e.getSource()==loadBtn){
				
				model.setRowCount(0);
				sql = "SELECT *  FROM claim "; PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = con.createStatement().executeQuery(sql);	
				while(rs.next()){
					model.addRow(new Object[]{		
							
							rs.getInt("ClaimID"),
							rs.getString("ClaimDate"),
							rs.getString("ClaimAmount"),
							rs.getString("Status"),
							rs.getString("PolicyID")
							
					});
					
				}
			}
			
			
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}

}

	

