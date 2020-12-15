package com.geng.student.view;

import com.geng.handler.LoginHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import static javax.swing.SpringLayout.*;

public class LoginView extends JFrame {
    JLabel nameLabel = new JLabel("<Student Manager System>", JLabel.CENTER);

    SpringLayout springLayout = new SpringLayout();
    JPanel centerPanel = new JPanel(springLayout);
    JLabel usernamaLabel = new JLabel("USER:");
    JTextField userTxt = new JTextField();
    JLabel pwdLabel = new JLabel("PWD:");
    JTextField pwdTxt = new JTextField();
    JButton loginBtn = new JButton("login");
    JButton resetBtn = new JButton("reset");

    LoginHandler loginHandler;

    TrayIcon trayIcon;
    SystemTray systemTray;


    public LoginView() {
        super("Java Studnt Score Manager");
        loginHandler = new LoginHandler(LoginView.this);
        Container contentPane = getContentPane();

        nameLabel.setFont(new Font("", Font.PLAIN, 40));
        Font centerFont = new Font("", Font.PLAIN, 20);
        nameLabel.setPreferredSize(new Dimension(0, 80));
//        usernamaLabel.setFont(centerFont);
//        pwdLabel.setFont(centerFont);
        loginBtn.setFont(centerFont);
        resetBtn.setFont(centerFont);

        userTxt.setPreferredSize(new Dimension(200, 30));
        pwdTxt.setPreferredSize(new Dimension(200, 30));
        centerPanel.add(usernamaLabel);
        centerPanel.add(userTxt);
        centerPanel.add(pwdLabel);
        centerPanel.add(pwdTxt);

        loginBtn.addActionListener(loginHandler);
        loginBtn.addKeyListener(loginHandler);
        centerPanel.add(loginBtn);
        resetBtn.addActionListener(loginHandler);
        centerPanel.add(resetBtn);

        layoutCenter();

        contentPane.add(nameLabel, BorderLayout.NORTH);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        if (SystemTray.isSupported()) {
            systemTray = SystemTray.getSystemTray();
            URL resource = LoginView.class.getClassLoader().getResource("dididi.png");
            trayIcon = new TrayIcon(new ImageIcon(resource).getImage());
            trayIcon.setImageAutoSize(true);
            try {
                systemTray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowIconified(WindowEvent e) {
                    LoginView.this.dispose();
                }
            });
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int clickCount = e.getClickCount();
                    if (clickCount == 1) {
                        LoginView.this.setExtendedState(JFrame.NORMAL);
                    }
                }
            });
        }
        //set loginBtn is default
        getRootPane().setDefaultButton(loginBtn);

        URL resource = LoginView.class.getClassLoader().getResource("xiaoji.png");
        setIconImage(new ImageIcon(resource).getImage());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 400);
        setVisible(true);
    }

    private void layoutCenter() {
        Spring childWidth = Spring.sum(Spring.sum(Spring.width(usernamaLabel), Spring.width(userTxt)), Spring.constant(20));
        int offSetX = childWidth.getValue() / 2;

        springLayout.putConstraint(WEST, usernamaLabel, -offSetX, HORIZONTAL_CENTER, centerPanel);
        springLayout.putConstraint(NORTH, usernamaLabel, 20, NORTH, centerPanel);
        //userTxt
        springLayout.putConstraint(WEST, userTxt, 20, EAST, usernamaLabel);
        springLayout.putConstraint(NORTH, userTxt, 0, NORTH, usernamaLabel);

        //pwdLabel
        springLayout.putConstraint(EAST, pwdLabel, 0, EAST, usernamaLabel);
        springLayout.putConstraint(NORTH, pwdLabel, 20, SOUTH, usernamaLabel);

        //pwdTxt
        springLayout.putConstraint(WEST, pwdTxt, 20, EAST, pwdLabel);
        springLayout.putConstraint(NORTH, pwdTxt, 0, NORTH, pwdLabel);

        //loginBtn
        springLayout.putConstraint(WEST, loginBtn, 50, WEST, pwdLabel);
        springLayout.putConstraint(NORTH, loginBtn, 20, SOUTH, pwdLabel);

        //resetBtn
        springLayout.putConstraint(WEST, resetBtn, 20, EAST, loginBtn);
        springLayout.putConstraint(NORTH, resetBtn, 0, NORTH, loginBtn);
    }

    public static void main(String[] args) {
        new LoginView();
    }

    public JTextField getUserTxt() {
        return userTxt;
    }
    public JTextField getPwdTxt() {
        return pwdTxt;
    }

}
