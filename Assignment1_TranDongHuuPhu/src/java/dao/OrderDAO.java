/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.MainController;
import dto.CartDTO;
import dto.OrderDTO;
import dto.ProductDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import util.DBUtils;

/**
 *
 * @author Admin
 */
public class OrderDAO {
    private final static Logger log = Logger.getLogger(OrderDAO.class);
    public boolean createOrder(CartDTO cart) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getCon();
            if (conn != null) {
                String sql = "INSERT INTO tblOrders (userID, totalPrice, orderDate, status) VALUES(?,?,?,?)";
                String orderID[] = {"orderID"};
                Date orderDate = Date.valueOf(LocalDate.now());
                float totalPrice = 0;
                boolean status = true;
                for (ProductDTO dto : cart.getCart().values()) {
                    totalPrice +=  dto.getQuantity() * dto.getPrice();
                }
                stm = conn.prepareStatement(sql, orderID);
                stm.setString(1, cart.getUserID());
                stm.setFloat(2, totalPrice);
                stm.setDate(3, orderDate);
                stm.setBoolean(4, status);
                stm.executeUpdate();
                rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    String orderDetailSql = "INSERT INTO tblOrderDetail (orderID, productID, price, quantity) VALUES (?,?,?,?)";
                    for (ProductDTO dto : cart.getCart().values()) {
                        stm = conn.prepareStatement(orderDetailSql);
                        stm.setInt(1, rs.getInt(1));
                        stm.setString(2, dto.getID());
                        stm.setFloat(3, dto.getPrice());
                        stm.setInt(4, dto.getQuantity());
                        stm.executeUpdate();
                    }
                    result = true;
                }
            }

        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
    public List<OrderDTO> getListOrder(String ID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDTO> list = null;
        try {
            conn = DBUtils.getCon();
            String sql = "SELECT orderID, userID, totalPrice, orderDate FROM tblOrders WHERE userID LIKE ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + ID + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                String orderID = rs.getString("orderID");
                String userID = rs.getString("userID");
                float totalPrice = rs.getFloat("totalPrice");
                String orderDate = rs.getString("orderDate");
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(new OrderDTO(orderID, userID, totalPrice, orderDate, null));
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    public List<ProductDTO> getListOrderDetail(String ID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ProductDTO> list = null;
        try {
            conn = DBUtils.getCon();
            String sql = "SELECT tblOrderDetail.productID, tblProducts.productName, tblOrderDetail.price, tblOrderDetail.quantity FROM tblOrderDetail INNER JOIN tblProducts ON tblOrderDetail.productID = tblProducts.productID   WHERE orderID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, ID);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(new ProductDTO(productID, productName, quantity, price, null, null, null, true));
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
}
