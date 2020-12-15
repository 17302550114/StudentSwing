package com.geng.student.view.ext;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class MainViewTableModel extends DefaultTableModel {
    static Vector<String> columns = new Vector();

    static {
        columns.addElement("Order");
        columns.addElement("Name");
        columns.addElement("Number");
        columns.addElement("Home");
        columns.addElement("Chinese");
        columns.addElement("Math");
        columns.addElement("English");
        columns.addElement("TotalScore");
    }

    private MainViewTableModel() {
        super(null, columns);
    }


    private static MainViewTableModel mainViewTableModel = new MainViewTableModel();

    public static MainViewTableModel assembleMode1(Vector<Vector<Object>> data) {
        mainViewTableModel.setDataVector(data, columns);
        return mainViewTableModel;
    }

    public static void updateModel(Vector<Vector<Object>> data) {
        mainViewTableModel.setDataVector(data, columns);
    }


    public static Vector<String> getColumns() {
        return columns;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
