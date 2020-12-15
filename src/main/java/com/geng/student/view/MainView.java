package com.geng.student.view;

import com.geng.handler.LoginHandler;
import com.geng.handler.MainViewhandle;
import com.geng.req.StudnetRequest;
import com.geng.res.TableDTO;
import com.geng.service.StudentService;
import com.geng.service.impl.StudentServiceImpl;
import com.geng.student.view.ext.MainViewTable;
import com.geng.student.view.ext.MainViewTableModel;
import com.geng.util.DimensionUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Vector;

import static javax.swing.SpringLayout.*;

public class MainView extends JFrame {

    JPanel northPanel = new JPanel();
    JButton addBtn = new JButton("ADD");
    JButton updateBtn = new JButton("UPDATE");
    JButton deleteBtn = new JButton("DELETE");
    static JTextField searchTxt = new JTextField(15);
    JButton searchBtn = new JButton("SEARCH");

    JPanel southPanel = new JPanel();
    JButton preBtn = new JButton("PRE");
    JButton nextBtn = new JButton("PNEXT");

    static MainViewTable mainViewTable = new MainViewTable();

    private static int pageNow = 1;
    private static int pageSize = 10;

    MainViewhandle mainViewhandle;

    public MainView() {
        super("Java Studnt Score Manager MainInterface");
        Container contentPane = getContentPane();
        mainViewhandle = new MainViewhandle(MainView.this);
        layoutNorth(contentPane);
        //setCenterJtable
        LayoutCenter(contentPane);
        layoutSouth(contentPane);


        URL resource = LoginView.class.getClassLoader().getResource("xiaoji.png");
        setIconImage(new ImageIcon(resource).getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        //根据屏幕大小设置主界面大小
        setBounds(DimensionUtil.getBounds());
        //设置窗体完全充满整个屏幕的可视大小
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }

    private void LayoutCenter(Container contentPane) {
        Vector<Vector<Object>> data = getVectors();
        System.out.println(data);

        MainViewTableModel mainViewTableModel = MainViewTableModel.assembleMode1(data);
        mainViewTable.setDataModel(mainViewTableModel);
        mainViewTable.renderRule();
        JScrollPane jScrollPane = new JScrollPane(mainViewTable);
        contentPane.add(jScrollPane, BorderLayout.CENTER);
    }

    private static Vector<Vector<Object>> getVectors() {
        StudentService studentService = new StudentServiceImpl();
        StudnetRequest request = new StudnetRequest();
        request.setPageNow(pageNow);
        request.setPageSize(pageSize);
        request.setSearchKey(searchTxt.getText().trim());
        TableDTO tableDTO = studentService.retrieveStudents(request);
        return tableDTO.getData();
    }

    private void layoutSouth(Container contentPane) {
        preBtn.addActionListener(mainViewhandle);
        nextBtn.addActionListener(mainViewhandle);
        southPanel.add(preBtn);
        southPanel.add(nextBtn);
        contentPane.add(southPanel, BorderLayout.SOUTH);
    }

    private void layoutNorth(Container contentPane) {

        //
        addBtn.addActionListener(mainViewhandle);
        updateBtn.addActionListener(mainViewhandle);
        deleteBtn.addActionListener(mainViewhandle);
        searchBtn.addActionListener(mainViewhandle);

        northPanel.add(addBtn);
        northPanel.add(updateBtn);
        northPanel.add(deleteBtn);
        northPanel.add(searchTxt);
        northPanel.add(searchBtn);


        contentPane.add(northPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new MainView();
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public static void reloadTable() {
        Vector<Vector<Object>> data = getVectors();
        MainViewTableModel.updateModel(data);
        mainViewTable.renderRule();
        System.out.println(data);
    }
}
