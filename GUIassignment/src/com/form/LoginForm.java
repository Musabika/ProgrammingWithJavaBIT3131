package com.form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    JLabel userLb = new JLabel("UserName");
    JLabel passLb = new JLabel("Password");
    JTextField userTxt = new JTextField();
    JPasswordField passTxt = new JPasswordField();
    JButton loginBtn = new JButton("Login");
    JButton cancelBtn = new JButton("Cancel");

    //constructor
    public LoginForm(){
        //create window
        setTitle("LOGIN SHAPES APP");
        setBounds(300,200,300,200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255,255,245));
        //set location and size
        userLb.setBounds(30,30,80,25);
        userTxt.setBounds(120,30,120,25);
        passLb.setBounds(30,70,80,25);
        passTxt.setBounds(120,70,120,25);
        loginBtn.setBounds(40,120,90,30);
        cancelBtn.setBounds(150,120,90,30);

        //add components to frame
        add(userLb); add(userTxt); add(passLb); add(passTxt); add(loginBtn); add(cancelBtn);

        //add action listener
        loginBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==loginBtn){
            String user = userTxt.getText();
            String pass = new String (passTxt.getPassword());
            if (user.equalsIgnoreCase("admin") && pass.equals("123")){
                JOptionPane.showMessageDialog(this,"Login Successful","success",JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new ShapesApp();
            } else if(e.getSource()==cancelBtn){
                int confirm = JOptionPane.showConfirmDialog(this,"Exiting Application","confirm", JOptionPane.YES_NO_CANCEL_OPTION);
                if(confirm == JOptionPane.YES_OPTION) System.exit(0);

            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}
