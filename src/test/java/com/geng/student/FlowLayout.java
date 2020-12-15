package com.geng.student;

import javax.swing.*;
import java.awt.*;

public class FlowLayout extends JFrame {
    //default flowlayout
    JPanel jPanel = new JPanel(new java.awt.FlowLayout((int) FlowLayout.LEFT_ALIGNMENT,80,30));
    JButton jButton1 = new JButton("TestBtn1");
    JButton jButton2 = new JButton("TestBtn2");
    JButton jButton3 = new JButton("TestBtn333333333");
    JButton jButton4 = new JButton("TestBtn4");
    JButton jButton5 = new JButton("TestBtn5");
    JButton jButton6 = new JButton("TestBtn6");
    JButton jButton7 = new JButton("TestBtn7");
    JButton jButton8 = new JButton("TestBtn8");
    JButton jButton9 = new JButton("TestBtn9");
    JButton jButton10 = new JButton("TestBtn10");

    public FlowLayout() {
        super("Test Border");
        Container contentPane = getContentPane();

        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton4);
        jPanel.add(jButton5);
        jPanel.add(jButton6);
        jPanel.add(jButton7);
        jPanel.add(jButton8);
        jPanel.add(jButton9);
        jPanel.add(jButton10);
        contentPane.add(jPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 400);
        setVisible(true);


    }


    public static void main(String[] args) {
        new FlowLayout();
    }


}
