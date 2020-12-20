package com.geng.handler;

import com.geng.entity.StudentDO;
import com.geng.service.StudentService;
import com.geng.service.impl.StudentServiceImpl;
import com.geng.student.view.AddStudentView;
import com.geng.student.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentViewHandler implements ActionListener {
    private AddStudentView addStudentView;
    private MainView mainView;

    public AddStudentViewHandler(AddStudentView addStudentView, MainView mainView) {
        this.addStudentView = addStudentView;
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("ADD".equals(text)) {
            StudentService studentService = new StudentServiceImpl();
            StudentDO studentDO = addStudentView.buildStudentDo();
            boolean addResult = studentService.add(studentDO);
            if (addResult) {
                //
                mainView.reloadTable();
            } else {
                JOptionPane.showMessageDialog(addStudentView, "Add Fail!");
            }
        }

    }
}
