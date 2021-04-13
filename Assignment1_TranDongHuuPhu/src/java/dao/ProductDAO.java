/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CategoryDTO;
import dto.ProductDTO;
import util.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
public class ProductDAO {

    private final static Logger log = Logger.getLogger(ProductDAO.class);

    public List<ProductDTO> getProducts() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBUtils util = new DBUtils();
        List<ProductDTO> list = new ArrayList<>();
        String query = "select productID,  productName, quantity, price, description, categoryID, image, status from tblProducts";
        try {
            conn = util.getCon();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("productID");
                String name = rs.getString("productName");
                int quantity = rs.getInt("quantity");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                String category = rs.getString("categoryID");
                String image = rs.getString("image");
                boolean status = rs.getBoolean("status");
                list.add(new ProductDTO(ID, name, quantity, price, description, category, image, status));
            }
        } catch (Exception e) {
            log.error(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<String> getListProductID() throws SQLException {
        List<String> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getCon();
            String sql = "SELECT productID FROM tblProducts";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productID = rs.getString(1);

                if (list == null) {
                    list = new ArrayList<String>();
                }
                list.add(productID);
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

    public List<ProductDTO> getAllProduct(int index) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBUtils util = new DBUtils();
        List<ProductDTO> list = new ArrayList<>();
        String query = "select productID,  productName, quantity, price, description, categoryID, image, status, createDate, updateDate from tblProducts WHERE quantity > 0  order by createDate offset ? rows fetch first 20 rows only";
        try {
            conn = util.getCon();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 20);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("productID");
                String name = rs.getString("productName");
                int quantity = rs.getInt("quantity");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                String category = rs.getString("categoryID");
                String image = rs.getString("image");
                boolean status = rs.getBoolean("status");
                String createDate = rs.getString("createDate");
                String updateDate = rs.getString("updateDate");
                list.add(new ProductDTO(ID, name, quantity, price, description, category, image, status, createDate, updateDate));
            }
        } catch (Exception e) {
            log.error(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<CategoryDTO> getAllCategory() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBUtils util = new DBUtils();
        List<CategoryDTO> list = new ArrayList<>();
        String query = "select categoryID, categoryName from tblCategory";
        try {
            conn = util.getCon();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                list.add(new CategoryDTO(ID, name));
            }
        } catch (Exception e) {
            log.error(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getProductByCategory(String Id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBUtils util = new DBUtils();
        List<ProductDTO> list = new ArrayList<>();
        String query = "select productID,  productName, quantity, price, description, categoryID, image, status from tblProducts where categoryID = ? and quantity > 0 and status = 1 order by createDate";
        try {
            conn = util.getCon();
            ps = conn.prepareStatement(query);
            ps.setString(1, Id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                int quantity = rs.getInt(3);
                float price = rs.getFloat(4);
                String description = rs.getString(5);
                String category = rs.getString(6);
                String image = rs.getString(7);
                boolean status = rs.getBoolean(8);
                list.add(new ProductDTO(ID, name, quantity, price, description, category, image, status));
            }
        } catch (Exception e) {
            log.error(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getProductByName(String productName, String categoryID, int index) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBUtils util = new DBUtils();
        List<ProductDTO> list = new ArrayList<>();
        String query = "select productID,  productName, quantity, price, description, categoryID, image, status, createDate, updateDate from tblProducts where productName like ? AND categoryID like ? AND status = 1 order by productID offset ? rows fetch first 20 rows only";
        try {
            conn = util.getCon();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + productName + "%");
            ps.setString(2, "%" + categoryID + "%");
            ps.setInt(3, (index - 1) * 20);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                int quantity = rs.getInt(3);
                float price = rs.getFloat(4);
                String description = rs.getString(5);
                String category = rs.getString(6);
                String image = rs.getString(7);
                boolean status = rs.getBoolean(8);
                String createDate = rs.getString(9);
                String updateDate = rs.getString(10);
                list.add(new ProductDTO(ID, name, quantity, price, description, category, image, status, createDate, updateDate));
            }
        } catch (Exception e) {
            log.error(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getProductByName2(String productName, String categoryID, int index) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBUtils util = new DBUtils();
        List<ProductDTO> list = new ArrayList<>();
        String query = "select productID,  productName, quantity, price, description, categoryID, image, status, createDate, updateDate from tblProducts where productName like ? AND categoryID like ? order by productID offset ? rows fetch first 20 rows only";
        try {
            conn = util.getCon();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + productName + "%");
            ps.setString(2, "%" + categoryID + "%");
            ps.setInt(3, (index - 1) * 20);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                int quantity = rs.getInt(3);
                float price = rs.getFloat(4);
                String description = rs.getString(5);
                String category = rs.getString(6);
                String image = rs.getString(7);
                boolean status = rs.getBoolean(8);
                String createDate = rs.getString(9);
                String updateDate = rs.getString(10);
                list.add(new ProductDTO(ID, name, quantity, price, description, category, image, status, createDate, updateDate));
            }
        } catch (Exception e) {
            log.error(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public ProductDTO getProductList(String id) throws SQLException {
        ProductDTO dto = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getCon();
            if (conn != null) {
                String sql = "SELECT productID, productName, quantity, price, status FROM tblProducts WHERE quantity > 0 AND status = 1 AND productID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();

                if (rs.next()) {
                    dto = new ProductDTO(rs.getString("productID"), rs.getString("productName"), 1, rs.getFloat("price"), null, null, null, true);
                }
            }

        } catch (Exception e) {
            log.error(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return dto;
    }

    public int getNumberPage(String productName, String categoryID) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getCon();
            if (conn != null) {
                String sql = "select COUNT(productID) from tblProducts where productName like ? AND categoryID like ? AND status = 1";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + productName + "%");
                ps.setString(2, "%" + categoryID + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    int total = rs.getInt(1);
                    int countPage = 0;
                    countPage = total / 20;
                    if (total % 20 != 0) {
                        countPage++;
                    }
                    return countPage;
                }
            }

        } catch (Exception e) {
            log.error(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return 0;
    }
     public int getNumberPage2(String productName, String categoryID) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getCon();
            if (conn != null) {
                String sql = "select COUNT(productID) from tblProducts where productName like ? AND categoryID like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + productName + "%");
                ps.setString(2, "%" + categoryID + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    int total = rs.getInt(1);
                    int countPage = 0;
                    countPage = total / 20;
                    if (total % 20 != 0) {
                        countPage++;
                    }
                    return countPage;
                }
            }

        } catch (Exception e) {
            log.error(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return 0;
    }

    public void updateProduct(ProductDTO dto) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getCon();
            String sql = "UPDATE tblProducts SET productName = ?, quantity=?, price = ?, description = ?, categoryID=?, image=?, status=?, updateDate=? WHERE productID = ?";
            Date updateDate = Date.valueOf(LocalDate.now());
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getName());
            stm.setInt(2, dto.getQuantity());
            stm.setFloat(3, dto.getPrice());
            stm.setString(4, dto.getDescription());
            stm.setString(5, dto.getCategory());
            stm.setString(6, dto.getImage());
            stm.setBoolean(7, dto.isStatus());
            stm.setDate(8, updateDate);
            stm.setString(9, dto.getID());
            stm.executeUpdate();

        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void DeleteProduct(String ID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getCon();
            String sql = "UPDATE tblProducts SET status=?, updateDate=? WHERE productID = ?";
            Date updateDate = Date.valueOf(LocalDate.now());
            stm = conn.prepareStatement(sql);
            stm.setBoolean(1, false);
            stm.setDate(2, updateDate);
            stm.setString(3, ID);
            stm.executeUpdate();

        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void createProduct(ProductDTO dto) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getCon();
            String sql = "INSERT INTO tblProducts (productID, productName, quantity, price, description, categoryID, image, status, createDate) VALUES (?,?,?,?,?,?,?,?,?)";
            Date createDate = Date.valueOf(LocalDate.now());
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getID());
            stm.setString(2, dto.getName());
            stm.setInt(3, dto.getQuantity());
            stm.setFloat(4, dto.getPrice());
            stm.setString(5, dto.getDescription());
            stm.setString(6, dto.getCategory());
            stm.setString(7, dto.getImage());
            stm.setBoolean(8, dto.isStatus());
            stm.setDate(9, createDate);
            stm.executeUpdate();

        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public boolean checkProductID(String productID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getCon();
            String sql = "SELECT productID FROM tblProducts WHERE productID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, productID);
            rs = stm.executeQuery();
            while (rs.next()) {
                return false;
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
        return true;
    }

    public boolean checkQuantity(String productID, int quantity) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getCon();
            String sql = "SELECT quantity FROM tblProducts WHERE productID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, productID);
            rs = stm.executeQuery();
            while (rs.next()) {
                int quantitySql = rs.getInt(1);
                if (quantity > quantitySql) {
                    return false;
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
        return true;
    }

    public static int getQuantity(String id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int quantity = 0;
        try {
            conn = DBUtils.getCon();
            String sql = "SELECT quantity from tblProducts WHERE productID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                quantity = rs.getInt(1);
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
        return quantity;
    }

    public void calculateQuantity(int orderQuantity, int storedQuantity, String productID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;

        int remainingQuantity = 0;
        try {
            conn = DBUtils.getCon();
            String sql = "UPDATE tblProducts SET quantity = ? WHERE productID = ?";
            stm = conn.prepareStatement(sql);
            remainingQuantity = storedQuantity - orderQuantity;
            System.out.println(remainingQuantity);

            stm.setInt(1, remainingQuantity);
            stm.setString(2, productID);
            stm.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public Map<String, String> loadCategoriesMap() throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Map<String, String> categoryMap = new HashMap<>();
        try {
            conn = DBUtils.getCon();
            String sql = "SELECT categoryID,categoryName FROM tblCategory";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                categoryMap.put(rs.getString("categoryID"), rs.getString("categoryName"));
            }
        } catch (Exception e) {
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
        return categoryMap;
    }

}
