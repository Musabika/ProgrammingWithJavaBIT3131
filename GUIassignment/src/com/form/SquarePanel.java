package com.form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquarePanel extends JPanel implements ActionListener {
    JLabel sideLbl = new JLabel("Side:");
    JTextField sideTxt = new JTextField();
    JButton calcBtn = new JButton("Calculate");
    JButton clearBtn = new JButton("Clear");

    JTable table;
    DefaultTableModel model;

    public SquarePanel() {
        setLayout(null);
        sideLbl.setBounds(30, 20, 80, 25);
        sideTxt.setBounds(120, 20, 100, 25);
        calcBtn.setBounds(50, 60, 100, 30);
        clearBtn.setBounds(160, 60, 100, 30);

        add(sideLbl); add(sideTxt);
        add(calcBtn); add(clearBtn);

        String[] cols = {"Side", "Area", "Perimeter"};
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
                double s = Double.parseDouble(sideTxt.getText());
                double area = s*s;
                double peri = 4*s;
                model.addRow(new Object[]{s, area, peri});
                JOptionPane.showMessageDialog(this, "Calculation done!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearBtn) {
            sideTxt.setText("");
            model.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Cleared!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

}
