package com.form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapesApp extends JFrame implements ActionListener {
    JTabbedPane tabbedPane = new JTabbedPane();
    //constructor
        public ShapesApp() {
            setTitle("SHAPES CALCULATOR");
            setBounds(100,100,600,500);
            setLayout(new BorderLayout());
            //Menu bar
            JMenuBar menuBar = new JMenuBar();

            JMenu fileMenu = new JMenu("File");
            JMenuItem newItemMenu = new JMenuItem("New");
            JMenuItem exitItem = new JMenuItem("Exit");
            fileMenu.add(newItemMenu);
            fileMenu.add(exitItem);

            JMenu shapesMenu = new JMenu("Shapes");
            shapesMenu.add(new JMenuItem("Circle"));
            shapesMenu.add(new JMenuItem("Rectangle"));
            shapesMenu.add(new JMenuItem("Square"));
            shapesMenu.add(new JMenuItem("Triangle"));

            JMenu toolsMenu = new JMenu("Tools");
            toolsMenu.add(new JMenuItem("History"));
            toolsMenu.add(new JMenuItem("Export"));

            JMenu helpMenu = new JMenu("Help");
            helpMenu.add(new JMenuItem("About"));

            JMenu extraMenu =new JMenu("Options");
            extraMenu.add(new JMenuItem("Settings "));
            extraMenu.add(new JMenuItem("Themes"));

            menuBar.add(fileMenu);
            menuBar.add(shapesMenu);
            menuBar.add(toolsMenu);
            menuBar.add(helpMenu);
            menuBar.add(extraMenu);
            setJMenuBar(menuBar);

            //Define the tabs
            tabbedPane.add("Circle", new CirclePanel());
            tabbedPane.add("Rectangle", new RectanglePanel());
            tabbedPane.add("Square", new SquarePanel());
            tabbedPane.add("Triangle", new TrianglePanel());

            add(tabbedPane,BorderLayout.CENTER);

            //Exit action
//          exitItem.addActionListener(e -> {
//               int confirm =JOptionPane.showConfirmDialog(this, "exit Application?", "confirm",JOptionPane.YES_NO_OPTION);
//                if (confirm == JOptionPane.YES_OPTION) System.exit(0);
//            });
          
          
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        public void actionPerformed(ActionEvent e) {

        }

   
}
