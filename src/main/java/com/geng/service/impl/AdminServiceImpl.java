package com.geng.service.impl;

import com.geng.entity.AdminDO;
import com.geng.service.AdminService;
import com.geng.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    @Override
    public boolean validateAdmin(AdminDO adminDO) {
        String userName = adminDO.getUserName();
        String pwdParam = adminDO.getPwd();

        String sql = "select pwd from manager where username = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            if (conn == null) {
                return false;
            }
            ps = conn.prepareStatement(sql);
            ps.setString(1, AdminDO.getUserName());
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String pwd = resultSet.getString(1);
                if (AdminDO.getPwd().equals(pwd)) {
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeRs(resultSet);
            DBUtil.closePs(ps);
            DBUtil.closeConn(conn);
        }
        return false;
    }
}
