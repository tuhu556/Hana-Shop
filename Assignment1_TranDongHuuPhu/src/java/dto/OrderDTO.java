/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDTO {
    private String orderID;
    private String userID;
    private float totalPrice;
    private String orderDate;
    private List<ProductDTO> list;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String userID, float totalPrice, String orderDate, List<ProductDTO> list) {
        this.orderID = orderID;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.list = list;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<ProductDTO> getList() {
        return list;
    }

    public void setList(List<ProductDTO> list) {
        this.list = list;
    }

    
    
}
