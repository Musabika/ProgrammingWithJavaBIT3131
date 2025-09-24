package com.form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectanglePanel extends JPanel implements ActionListener {

    JLabel widthLbl = new JLabel("Width : ");
    JTextField widthTxt = new JTextField();
    JLabel lengthLbl = new JLabel("Length : ");
    JTextField lengthTxt = new JTextField();
    JButton calcBtn = new JButton("Calculate");
    JButton clearBtn = new JButton("Clear");

    JTable table;
    DefaultTableModel model;

    public RectanglePanel() {
        setLayout(null);
        widthLbl.setBounds(30, 20, 80, 25);
        widthTxt.setBounds(120, 20, 100, 25);
        
        lengthLbl.setBounds(30, 50, 80, 25);
        lengthTxt.setBounds(120, 50, 100, 25);
        
        calcBtn.setBounds(50, 80, 100, 30);
        clearBtn.setBounds(160, 80, 100, 30);

        add(widthLbl); add(widthTxt);
        add(lengthLbl); add(lengthTxt);
        add(calcBtn); add(clearBtn);

        String[] cols = {"width","length", "Area", "Perimeter"};
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(30, 110, 500, 250);
        add(scroll);

        calcBtn.addActionListener(this);
        clearBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcBtn) {
            try {
                double width = Double.parseDouble(widthTxt.getText());
                double length = Double.parseDouble(lengthTxt.getText());
                double area = width * length;
                double peri = (width + length) * 2;
                model.addRow(new Object[]{width,length, area, peri});
                JOptionPane.showMessageDialog(this, "Calculation done!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearBtn) {
           widthTxt.setText("");
            lengthTxt.setText("");
            model.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Cleared!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

}
