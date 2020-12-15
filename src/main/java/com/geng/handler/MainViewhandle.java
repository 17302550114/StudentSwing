package com.geng.handler;

import com.geng.student.view.MainView;
import com.sun.deploy.association.Action;
import sun.applet.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainViewhandle implements ActionListener {
    private MainView mainView;
    public MainViewhandle(MainView mainView){
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton)e.getSource();
        String text = jButton.getText();
        if ("ADD".equals(text)){
            System.out.printf("111111");

        }else if ("UPDATE".equals(text)){

        }else if ("DELETE".equals(text)){

        }else if("SEARCH".equals(text)){
            mainView.setPageNow(1);
            MainView.reloadTable();
        }
        else if("PRE".equals(text)){
            mainView.setPageNow(mainView.getPageNow()-1);
            MainView.reloadTable();
        }else if("PNEXT".equals(text)){
            mainView.setPageNow(mainView.getPageNow()+1);
            MainView.reloadTable();
        }

    }

}
