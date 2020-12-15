package com.geng.student;

import javax.swing.*;
import javax.swing.table.*;
import javax.xml.bind.ValidationException;
import java.awt.*;
import java.util.Vector;

public class JtableDemo02 extends JFrame {
    public JtableDemo02() {
        super("JtableDemo02");
        Vector<Object> columns = new Vector<Object>();
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        columns.addElement("ID");
        columns.addElement("Name");
        columns.addElement("Num");
        columns.addElement("Home");
        columns.addElement("Chinese");
        columns.addElement("Math");
        columns.addElement("English");
        columns.addElement("Total");
        Vector<Object> rowVwctor1 = new Vector<Object>();
        Vector<Object> rowVwctor2 = new Vector<Object>();
        Vector<Object> rowVwctor3 = new Vector<Object>();
        rowVwctor1.addElement("1");
        rowVwctor1.addElement("zhangsan");
        rowVwctor1.addElement("no1");
        rowVwctor1.addElement("nanjing");
        rowVwctor1.addElement("1");
        rowVwctor1.addElement("2");
        rowVwctor1.addElement("3");
        rowVwctor1.addElement("6");
        rowVwctor2.addElement("2");
        rowVwctor2.addElement("zhangsan");
        rowVwctor2.addElement("no2");
        rowVwctor2.addElement("nanjing");
        rowVwctor2.addElement("2");
        rowVwctor2.addElement("3");
        rowVwctor2.addElement("4");
        rowVwctor2.addElement("9");
        rowVwctor3.addElement("3");
        rowVwctor3.addElement("zhangsan");
        rowVwctor3.addElement("no3");
        rowVwctor3.addElement("nanjing");
        rowVwctor3.addElement("3");
        rowVwctor3.addElement("4");
        rowVwctor3.addElement("5");
        rowVwctor3.addElement("12");
        data.addElement(rowVwctor1);
        data.addElement(rowVwctor2);
        data.addElement(rowVwctor3);

        //tableModel
        StudentTableModel studentTableModel = StudentTableModel.assembleModel(data);
        JTable jTable = new JTable(studentTableModel);
        //set head
        JTableHeader tableHeader = jTable.getTableHeader();
        tableHeader.setFont(new Font(null, Font.BOLD, 16));
        tableHeader.setForeground(Color.RED);
        //biaogeti
        jTable.setFont(new Font(null, Font.PLAIN, 14));
        jTable.setForeground(Color.black);
        jTable.setGridColor(Color.BLACK);
        jTable.setRowHeight(30);
        //shezhiduohangxuanze
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        Vector<Object> columns1 = StudentTableModel.getColumns();
        StudentCellRender studentCellRender = new StudentCellRender();
        for (int i = 0; i < columns1.size(); i++) {
            TableColumn column = jTable.getColumn(columns1.get(i));
            column.setCellRenderer(studentCellRender);
            if (i==0){
                column.setPreferredWidth(50);
                column.setMaxWidth(50);
                column.setResizable(false);
            }
        }

        Container contentPane = getContentPane();
        JScrollPane jScrollPane = new JScrollPane(jTable);
        contentPane.add(jScrollPane);


        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new JtableDemo02();
    }

}

class StudentTableModel extends DefaultTableModel {
    static Vector<Object> columns = new Vector<Object>();
    static {
        columns.addElement("ID");
        columns.addElement("Name");
        columns.addElement("Num");
        columns.addElement("Home");
        columns.addElement("Chinese");
        columns.addElement("Math");
        columns.addElement("English");
        columns.addElement("Total");
    }

    private StudentTableModel() {
        super(null,columns);
    }

    private static StudentTableModel studentTableModel = new StudentTableModel();
    public static StudentTableModel assembleModel(Vector<Vector<Object>> data){
        studentTableModel.setDataVector(data,columns);
        return studentTableModel;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public static Vector<Object> getColumns() {
        return columns;
    }
}

class  StudentCellRender extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(row%2==0){
            setBackground(Color.GRAY);
        }else {
            setBackground(Color.WHITE);
        }
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}