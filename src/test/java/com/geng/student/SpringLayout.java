package com.geng.student;

import javax.swing.*;
import java.awt.*;

public class SpringLayout extends JFrame {

    javax.swing.SpringLayout springLayout = new javax.swing.SpringLayout();
    JPanel jPanel = new JPanel(springLayout);
    JTextField jTextField = new JTextField();
    JLabel autorLebal = new JLabel("autor");
    JLabel contentLabel = new JLabel("input contnet");
    JTextArea jTextArea = new JTextArea(4, 10);
    JLabel titleLabel = new JLabel("texttitle");

    public SpringLayout() {
        super("Test Spring");
        Container contentPane = getContentPane();
        jPanel.add(titleLabel);
        jTextField.setPreferredSize(new Dimension(200, 20));
        jPanel.add(jTextField);
        jPanel.add(autorLebal);
//        jPanel.add(contentLabel);
//        jPanel.add(jTextArea);
//        jPanel.add(titleLabel);
        javax.swing.SpringLayout.Constraints titleLabelC = springLayout.getConstraints(titleLabel);
        titleLabelC.setX(Spring.constant(100));
        titleLabelC.setY(Spring.constant(50));

        javax.swing.SpringLayout.Constraints titleTextC = springLayout.getConstraints(jTextField);
        Spring titleLabelEastSpring = titleLabelC.getConstraint(javax.swing.SpringLayout.EAST);
        titleTextC.setConstraint(javax.swing.SpringLayout.WEST,Spring.sum(titleLabelEastSpring,Spring.constant(20)));
        titleTextC.setConstraint(javax.swing.SpringLayout.NORTH,titleLabelC.getConstraint(javax.swing.SpringLayout.NORTH));
        //method2
        /**
         * @param   e1 the edge of the depen
         * @param   c1 the component of the dependen
         * @param   pad the fixed distance between d
         * @param   e2 the edge of the anchor
         * @param   c2 the component of the anchor
         */
        springLayout.putConstraint(javax.swing.SpringLayout.EAST,autorLebal,0, javax.swing.SpringLayout.EAST,titleLabel);
        springLayout.putConstraint(javax.swing.SpringLayout.NORTH,autorLebal,30, javax.swing.SpringLayout.NORTH,titleLabel);


        contentPane.add(jPanel);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(600, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SpringLayout();
    }
}
