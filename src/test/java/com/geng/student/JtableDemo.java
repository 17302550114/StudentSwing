package com.geng.student;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.Vector;

@SuppressWarnings("ALL")
public class JtableDemo extends JFrame {
    public JtableDemo() throws HeadlessException {
        super("JTable Demo");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        Vector<Object> rowVectoe1 = new Vector<Object>();
        rowVectoe1.addElement("1");
        rowVectoe1.addElement("AAA");
        rowVectoe1.addElement("no1");
        rowVectoe1.addElement("Xuzhou");
        rowVectoe1.addElement("1");
        rowVectoe1.addElement("2");
        rowVectoe1.addElement("3");
        rowVectoe1.addElement("6");

        Vector<Object> rowVectoe2 = new Vector<Object>();
        rowVectoe2.addElement("2");
        rowVectoe2.addElement("BBB");
        rowVectoe2.addElement("no2");
        rowVectoe2.addElement("Taizhou");
        rowVectoe2.addElement("2");
        rowVectoe2.addElement("3");
        rowVectoe2.addElement("4");
        rowVectoe2.addElement("8");

        Vector<Object> rowVectoe3 = new Vector<Object>();
        rowVectoe3.addElement("3");
        rowVectoe3.addElement("CCC");
        rowVectoe3.addElement("no3");
        rowVectoe3.addElement("Qingdao");
        rowVectoe3.addElement("4");
        rowVectoe3.addElement("2");
        rowVectoe3.addElement("2");
        rowVectoe3.addElement("8");


        data.addElement(rowVectoe1);
        data.addElement(rowVectoe2);
        data.addElement(rowVectoe3);


        //tableModel
        StudentTableModel studentTableModel = StudentTableModel.assembleMode1(data);

        //jtable
        JTable jTable = new JTable(studentTableModel);
        JTableHeader tableHeader = jTable.getTableHeader();
        tableHeader.setFont(new Font(null, Font.BOLD, 16));
        tableHeader.setForeground(Color.RED);
        jTable.setFont(new Font(null, Font.PLAIN, 14));
        jTable.setForeground(Color.BLACK);
        jTable.setGridColor(Color.BLACK);
        jTable.setRowHeight(30);
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //设置表格列的渲染方式
        Vector<String> columns = StudentTableModel.getColumns();
        StudentCellRender render = new StudentCellRender();
        for (int i = 0; i < columns.size(); i++) {
            TableColumn column = jTable.getColumn(columns.get(i));
            column.setCellRenderer(render);
            if (i==0){
                column.setPreferredWidth(50);
                column.setMaxWidth(50);
                column.setResizable(false);
            }
        }

        Container container = getContentPane();
        JScrollPane jScrollPane = new JScrollPane(jTable);
        container.add(jScrollPane);

        setSize(600, 400);//px
        /*juzhong*/
        setLocationRelativeTo(null);
        //guanbiyaotuichuchengxu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //daxiaobubian
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JtableDemo();
    }

    class StudentCellRender extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (row%2==0){
                setBackground(Color.LIGHT_GRAY);

            }else {
                setBackground(Color.WHITE);
            }
            setHorizontalAlignment(DefaultListCellRenderer.CENTER);
            return super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        }
    }

    static class StudentTableModel extends DefaultTableModel {
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

        private StudentTableModel() {
            super(null, columns);
        }


        private static StudentTableModel studentTableModel = new StudentTableModel();

        public static StudentTableModel assembleMode1(Vector<Vector<Object>> data) {
            studentTableModel.setDataVector(data, columns);
            return studentTableModel;
        }

        public static Vector<String> getColumns() {
            return columns;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
}
