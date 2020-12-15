package com.geng.handler;

import com.geng.entity.AdminDO;
import com.geng.service.AdminService;
import com.geng.service.impl.AdminServiceImpl;
import com.geng.student.view.LoginView;
import com.geng.student.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Handler;

public class LoginHandler extends KeyAdapter implements ActionListener {
    private LoginView loginView;

    public LoginHandler(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("reset".equals(text)) {
            loginView.getUserTxt().setText("");
            loginView.getPwdTxt().setText("");
        } else if ("login".equals(text)) {
            login();
        }
    }

    private void login() {
        String user = loginView.getUserTxt().getText();
        String pwd = loginView.getPwdTxt().getText();
        if (user == null || "".equals(user.trim()) || pwd == null) {
            JOptionPane.showMessageDialog(loginView, "Please Input UserName and Password");
            return;
        }

        //query db
        AdminService adminService = new AdminServiceImpl();
        AdminDO adminDO = new AdminDO();
        adminDO.setUserName(user);
        adminDO.setPwd(pwd);
        boolean flag = adminService.validateAdmin(adminDO);
        if (flag) {
            //to MainView
            new MainView();
            loginView.dispose();
        } else {
            JOptionPane.showMessageDialog(loginView, "user or pwd Error!");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ENTER == e.getKeyCode()) {
            login();
        }
    }
}
