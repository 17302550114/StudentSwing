package com.geng.student.view;

import com.geng.entity.StudentDO;
import com.geng.handler.AddStudentViewHandler;

import javax.swing.*;
import java.awt.*;

public class AddStudentView extends JDialog {
    AddStudentViewHandler addStudentViewHandler;
    JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
    JLabel nameLabel = new JLabel("Name", JLabel.RIGHT);
    JTextField nameText = new JTextField();
    JLabel noLabel = new JLabel("Number", JLabel.RIGHT);
    JTextField noText = new JTextField();
    JLabel homeLabel = new JLabel("HomeTown", JLabel.RIGHT);
    JTextField homeText = new JTextField();
    JLabel cnLabel = new JLabel("CNScore", JLabel.RIGHT);
    JTextField cnText = new JTextField();
    JLabel mathLabel = new JLabel("MathScore", JLabel.RIGHT);
    JTextField mathText = new JTextField();
    JLabel enLabel = new JLabel("ENScore", JLabel.RIGHT);
    JTextField enText = new JTextField();

    JButton addButton = new JButton("ADD");

    public AddStudentView(MainView mainView) {
        super(mainView, "addtudent", true);

        addStudentViewHandler = new AddStudentViewHandler(this,mainView);
        nameLabel.setPreferredSize(new Dimension(80, 30));
        jPanel.add(nameLabel);
        nameText.setPreferredSize(new Dimension(200, 30));
        jPanel.add(nameText);

        noLabel.setPreferredSize(new Dimension(80, 30));
        jPanel.add(noLabel);
        noText.setPreferredSize(new Dimension(200, 30));
        jPanel.add(noText);
        homeLabel.setPreferredSize(new Dimension(80, 30));
        jPanel.add(homeLabel);
        homeText.setPreferredSize(new Dimension(200, 30));
        jPanel.add(homeText);
        cnLabel.setPreferredSize(new Dimension(80, 30));
        jPanel.add(cnLabel);
        cnText.setPreferredSize(new Dimension(200, 30));
        jPanel.add(cnText);
        mathLabel.setPreferredSize(new Dimension(80, 30));
        jPanel.add(mathLabel);
        mathText.setPreferredSize(new Dimension(200, 30));
        jPanel.add(mathText);
        enLabel.setPreferredSize(new Dimension(80, 30));
        jPanel.add(enLabel);
        enText.setPreferredSize(new Dimension(200, 30));
        jPanel.add(enText);

        addButton.addActionListener(addStudentViewHandler);
        jPanel.add(addButton);
        Container contentPane = getContentPane();
        contentPane.add(jPanel);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(350, 500);
        setVisible(true);
    }

    public StudentDO buildStudentDo() {
        StudentDO studentDO = new StudentDO();
        studentDO.setName(nameText.getText());
        studentDO.setNumber(noText.getText());
        studentDO.setHome(homeText.getText());
        studentDO.setChinese(Double.valueOf(cnText.getText()));
        studentDO.setEnglish(Double.valueOf(enText.getText()));
        studentDO.setMath(Double.valueOf(mathText.getText()));
        return studentDO;
    }
}
