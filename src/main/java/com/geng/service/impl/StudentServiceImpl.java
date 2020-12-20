package com.geng.service.impl;

import com.geng.entity.StudentDO;
import com.geng.req.StudnetRequest;
import com.geng.res.TableDTO;
import com.geng.service.StudentService;
import com.geng.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StudentServiceImpl implements StudentService {
    @Override
    public TableDTO retrieveStudents(StudnetRequest request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from student");
        if (request.getSearchKey() != null && !"".equals(request.getSearchKey().trim())) {
            sql.append(" where name  like '%" + request.getSearchKey().trim() + "%'");
        }
        sql.append(" order by id asc limit ")
                .append(request.getStart()).append(",")
                .append(request.getPageSize());
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TableDTO retrunDTO = new TableDTO();
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            retrunDTO.setData(fillData(rs));
            sql.setLength(0);
            sql.append("select count(*) from student");
            if (request.getSearchKey() != null && !"".equals(request.getSearchKey().trim())) {
                sql.append(" where name like '%" + request.getSearchKey().trim() + "%'");
            }
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                int count = rs.getInt(1);
                retrunDTO.setTatalCount(count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeRs(rs);
            DBUtil.closePs(ps);
            DBUtil.closeConn(conn);
        }
        return retrunDTO;
    }

    @Override
    public boolean add(StudentDO studentDO) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into student(Name,Number,Home,Chinese,Math,English) ");
        sql.append("value(?,?,?,?,?,?) ");

        Connection conn = null;
        PreparedStatement ps = null;
        TableDTO retrunDTO = new TableDTO();
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, studentDO.getName());
            ps.setString(2, studentDO.getNumber());
            ps.setString(3, studentDO.getHome());
            ps.setDouble(4, studentDO.getChinese());
            ps.setDouble(5, studentDO.getEnglish());
            ps.setDouble(6, studentDO.getMath());
            return (ps.executeUpdate() == 1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePs(ps);
            DBUtil.closeConn(conn);
        }
        return true;
    }

    private Vector<Vector<Object>> fillData(ResultSet rs) throws SQLException {
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> oneRecord = new Vector<Object>();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String no = rs.getString("no");
            String homeTown = rs.getString("home_towm");
            int cnScore = rs.getInt("cn_score");
            int enScore = rs.getInt("en_score");
            int mathScore = rs.getInt("math_score");
            int tatolScore = cnScore + enScore + mathScore;
            oneRecord.addElement(id);
            oneRecord.addElement(name);
            oneRecord.addElement(no);
            oneRecord.addElement(homeTown);
            oneRecord.addElement(cnScore);
            oneRecord.addElement(enScore);
            oneRecord.addElement(mathScore);
            oneRecord.addElement(tatolScore);
            data.addElement(oneRecord);
        }
        return data;
    }
}
