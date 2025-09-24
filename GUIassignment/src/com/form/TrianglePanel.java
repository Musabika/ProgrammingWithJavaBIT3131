package com.form;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrianglePanel extends JPanel implements ActionListener {
    JLabel baseLbl = new JLabel("Base:");
    JLabel heightLbl = new JLabel("Height:");
    JLabel hypothenusLbl = new JLabel("Hypothenus:");
    JTextField baseTxt = new JTextField();
    JTextField heightTxt = new JTextField();
    JTextField hypothenusTxt = new JTextField();
    JButton calcBtn = new JButton("Calculate");
    JButton clearBtn = new JButton("Clear");

    JTable table;
    DefaultTableModel model;
    //constructor
    public TrianglePanel() {
        setLayout(null);

        baseLbl.setBounds(30, 20, 80, 25);
        baseTxt.setBounds(120, 20, 100, 25);
        heightLbl.setBounds(30, 50, 80, 25);
        heightTxt.setBounds(120, 50, 100, 25);
        hypothenusLbl.setBounds(30, 80, 80, 25);
        hypothenusTxt.setBounds(120, 80, 100, 25);
        calcBtn.setBounds(50, 110, 100, 30);
        calcBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearBtn.setBounds(160, 110, 100, 30);
        clearBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(baseLbl); add(heightLbl); add(hypothenusLbl); add(baseTxt); add(hypothenusTxt); add(heightTxt);
        add(calcBtn); add(clearBtn);

        String[] cols = {"Base", "Height", "Hypothenus","Area","Perimeter"};
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(30, 150, 500, 250);
        add(scroll);

        calcBtn.addActionListener(this);
        clearBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcBtn) {
            try {
                double b = Double.parseDouble(baseTxt.getText());
                double h = Double.parseDouble(heightTxt.getText());
                double hy = Double.parseDouble(hypothenusTxt.getText());
                double area = (b*h)/2;
                double peri = b +h+hy;
                model.addRow(new Object[]{b,h,hy, area, peri});
                JOptionPane.showMessageDialog(this, "Calculation done!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearBtn) {
            baseTxt.setText("");
            heightTxt.setText("");
            hypothenusTxt.setText("");
            model.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Cleared!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

}
