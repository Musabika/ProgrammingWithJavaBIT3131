package com.form;

import java.awt.BorderLayout;

import javax.swing.*;


//Group Members 

//Fidele MUSABIKA 223003195
//UMURERWA Aline Carine 223010696
//TUYIKUNDE Rebecca 223010994


public class IMS  extends JFrame{

	JTabbedPane tabs = new JTabbedPane();
	
	public IMS(String role, int userid){
	setTitle("INSURANCE Management System");
	setSize(900,800);
	setLayout(new BorderLayout());
		
		if(role.equalsIgnoreCase("manager")){
			tabs.add("User",new UsersPanel());
			tabs.add("Asset",new AssetPanel());
			tabs.add("Customers",new CustomersPanel());
			tabs.add("Policy",new PolicyPanel());
			tabs.add("Claim",new ClaimPanel());
			tabs.add("Claim Assessment",new claimassessmentPanel());
					
		}
		else if(role.equalsIgnoreCase("reception")){
			tabs.add("Customers",new CustomersPanel());
			tabs.add("Policy",new PolicyPanel());
			tabs.add("Claim",new ClaimPanel());
			
		}
		else if(role.equalsIgnoreCase("consultant")){
			tabs.add("Customers",new CustomersPanel());
			tabs.add("Claim",new ClaimPanel());
			tabs.add("Claim Assessment",new claimassessmentPanel());
			
		}
		
		add(tabs,BorderLayout.CENTER);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	}


