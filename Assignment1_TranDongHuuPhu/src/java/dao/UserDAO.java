/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.LoginController;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import util.DBUtils;

/**
 *
 * @author Admin
 */
public class UserDAO {
    private final static Logger log = Logger.getLogger(UserDAO.class);
     public UserDTO checkLogin(String userID, String password) throws ClassNotFoundException, SQLException {
        UserDTO result = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getCon();
            String sql = "select fullName, roleID, status FROM tblUsers WHERE userID =? AND password =?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                String fullName = rs.getString("fullName");
                String role = rs.getString("roleID");
                boolean status = rs.getBoolean("status");
                result = new UserDTO(userID, role, fullName, password, "","", status);
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();

            }
            if (rs != null) {
                rs.close();

            }
        }
        return result;
    }
     public void createGG(UserDTO dto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getCon();
            String sql = "INSERT INTO tblUsers (userID, roleID, fullName, password, email, phone, status) VALUES(?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getUserID());
            ps.setString(2, dto.getRoleID());
            ps.setString(3, dto.getFullName());
            ps.setString(4, dto.getPassword());
            ps.setString(5, dto.getEmail());
            ps.setString(6, dto.getPhone());
            ps.setBoolean(7, dto.isStatus());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }
}
