package com.geng.student.view;

import javax.swing.*;
import java.awt.*;

public class UpdateStudentView extends JDialog {
    static MainView mainView = new MainView();
    JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));

    JLabel IDLabel = new JLabel("ID",JLabel.RIGHT);
    JTextField idText = new JTextField();

    JLabel nameLabel = new JLabel("Name",JLabel.RIGHT);
    JTextField nameText = new JTextField();
    JLabel noLabel = new JLabel("Number",JLabel.RIGHT);
    JTextField noText = new JTextField();
    JLabel homeLabel = new JLabel("HomeTown",JLabel.RIGHT);
    JTextField homeText = new JTextField();
    JLabel cnLabel = new JLabel("CNScore",JLabel.RIGHT);
    JTextField cnText = new JTextField();
    JLabel mathLabel = new JLabel("MathScore",JLabel.RIGHT);
    JTextField mathText = new JTextField();
    JLabel enLabel = new JLabel("ENScore",JLabel.RIGHT);
    JTextField enText = new JTextField();

    JButton upDateButton = new JButton("ADD");

    public UpdateStudentView(MainView mainView) {
        super(mainView, "UpdateStudent", true);

        IDLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(IDLabel);
        idText.setPreferredSize(new Dimension(200,30));
        jPanel.add(idText);

        nameLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(nameLabel);
        nameText.setPreferredSize(new Dimension(200,30));
        jPanel.add(nameText);

        noLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(noLabel);
        noText.setPreferredSize(new Dimension(200,30));
        jPanel.add(noText);
        homeLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(homeLabel);
        homeText.setPreferredSize(new Dimension(200,30));
        jPanel.add(homeText);
        cnLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(cnLabel);
        cnText.setPreferredSize(new Dimension(200,30));
        jPanel.add(cnText);
        mathLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(mathLabel);
        mathText.setPreferredSize(new Dimension(200,30));
        jPanel.add(mathText);
        enLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(enLabel);
        enText.setPreferredSize(new Dimension(200,30));
        jPanel.add(enText);
        jPanel.add(upDateButton);
        Container contentPane = getContentPane();
        contentPane.add(jPanel);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(350, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateStudentView(mainView);
    }
}
