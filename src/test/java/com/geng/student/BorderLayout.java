package com.geng.student;

import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;

public class BorderLayout extends JFrame {
    JButton northBtn = new JButton("northbtn");
    JLabel southLabel = new JLabel("southlabel");
    JRadioButton westRadioBtn = new JRadioButton("nan");
    JTextArea eastArea = new JTextArea("input something", 10, 20);
    JButton centerBtn = new JButton("centerbutton");

    public BorderLayout() {
        super("Test Border");
        Container contentPane = getContentPane();
        contentPane.setLayout(new java.awt.BorderLayout());
        northBtn.setPreferredSize(new Dimension(0,80));
        contentPane.add(northBtn, java.awt.BorderLayout.NORTH);

        contentPane.add(southLabel, java.awt.BorderLayout.SOUTH);
        westRadioBtn.setPreferredSize(new Dimension(200, 0));
        contentPane.add(eastArea, java.awt.BorderLayout.EAST);
        contentPane.add(westRadioBtn, java.awt.BorderLayout.WEST);
        contentPane.add(centerBtn, java.awt.BorderLayout.CENTER);


        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 400);
        setVisible(true);


    }


    public static void main(String[] args) {
        new BorderLayout();
    }


}
