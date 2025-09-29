package com.form;

import java.awt.BorderLayout;

import javax.swing.*;

public class SMIS extends JFrame{
	JTabbedPane tabs = new JTabbedPane();
	
	public SMIS(String role, int userid){
		setTitle("School Management System");
		setSize(900,600);
		setLayout(new BorderLayout());
		
		if(role.equalsIgnoreCase("admin")){
			tabs.add("User",new UserPanel());
			tabs.add("Teacher",new TeacherPanel());
			tabs.add("Courses",new CoursePanel());
			tabs.add("Students",new StudentPanel());
			tabs.add("Marks",new MarkPanel());
					
		}else if(role.equalsIgnoreCase("teacher")){
			tabs.add("Courses",new CoursePanel());
			tabs.add("Marks",new MarkPanel());
		}else if(role.equalsIgnoreCase("student")){
			tabs.add("Students",new StudentPanel());
		}
		add(tabs,BorderLayout.CENTER);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
