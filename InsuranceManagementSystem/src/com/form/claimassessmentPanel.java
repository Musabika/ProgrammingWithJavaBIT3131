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

// Group Members 

// Fidele MUSABIKA 223003195
// UMURERWA Aline Carine 223010696
//TUYIKUNDE Rebecca 223010994

public class claimassessmentPanel extends JPanel implements ActionListener {
	
	//components 							
						
		JTextField AssessmentIdTxt = new JTextField();
		JTextField ReportDateTxt = new JTextField();
		JTextField AssessedLossTxt = new JTextField();
		JTextField NotesTxt = new JTextField();
		JTextField ClaimIDTxt = new JTextField();

		
		JButton addBtn = new JButton ("Add"),
				updateBtn = new JButton ("Update"),
				deleteBtn = new JButton ("Delete"),
				loadBtn = new JButton ("Load");
		
		JTable table;
		DefaultTableModel model;
		
		//Constructor
		
		public claimassessmentPanel(){
			
			setLayout(null);
	

			String [] labels = {"AssessmentId","ReportDate","AssessedLoss","Notes","ClaimID"};
			String [] cols = {"AssessmentId","ReportDate","AssessedLoss","Notes","ClaimID"};
			
			model = new DefaultTableModel(labels,0);
			table = new JTable(model);
			
			JScrollPane sp = new JScrollPane(table);
			sp.setBounds(20, 200, 800, 300);
			
			int y = 20;			
								
			addField("Assessment Id",AssessmentIdTxt,y);
			y+=30;
			addField("Report Date",ReportDateTxt,y);
			y+=30;
			addField("Assessed Loss",AssessedLossTxt,y);
			y+=30;
			addField("Notes",NotesTxt,y);
			y+=30;
			addField("Claim ID",ClaimIDTxt,y);
			
			
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
			l.setBounds(20, y, 100, 25);
			txt.setBounds(140, y, 150, 25);
			add(l);
			add(txt);
			
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		try(Connection con = DB.getConnection()){
			String sql = null;
			if(e.getSource()==addBtn){
				 sql= "INSERT INTO claimassessment (ReportDate,AssessedLoss,Notes,ClaimID) VALUES(?,?,?,?)";
				
				PreparedStatement ps = con.prepareStatement(sql);

				//ps.setString(1, assetIdTxt.getText());

																

				ps.setString(1, ReportDateTxt.getText());
				
				ps.setString(2, AssessedLossTxt.getText());
				
				ps.setString(3, NotesTxt.getText());

				ps.setString(4, ClaimIDTxt.getText());

				ps.executeUpdate();
				
			}
			else if(e.getSource()==updateBtn){
					
					
				sql = "UPDATE claimassessment SET ReportDate =?, AssessedLoss = ?,Notes = ?,ClaimID = ? WHERE AssessmentId = ?"; 
				
				PreparedStatement ps = con.prepareStatement(sql);
									
				
				ps.setString(1, ReportDateTxt.getText());

				ps.setString(2, AssessedLossTxt.getText());

				ps.setString(3, NotesTxt.getText());

				ps.setString(4, ClaimIDTxt.getText());

				
				ps.setInt(5, Integer.parseInt(AssessmentIdTxt.getText()));
				
				ps.executeUpdate();
			
 			}
				else if(e.getSource()==deleteBtn){
				sql = "DELETE FROM claimassessment WHERE AssessmentId = ?"; 
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(AssessmentIdTxt.getText()));			
				ps.executeUpdate();
			}
			else if(e.getSource()==loadBtn){
				
				model.setRowCount(0);
				sql = "SELECT *  FROM claimassessment "; PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = con.createStatement().executeQuery(sql);	
				while(rs.next()){
					model.addRow(new Object[]{

					
							rs.getInt("AssessmentId"),
							rs.getString("ReportDate"),
							rs.getString("AssessedLoss"),
							rs.getString("Notes"),
							rs.getString("ClaimID")
							
					});
					
				}
			}
			
			
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}

}

	

