/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dao.ProductDAO;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Admin
 */
public class CartDTO {
    private String userID;
    private int quantiny;
    private Map<String,ProductDTO> cart;

    public CartDTO() {
    }

    public CartDTO(String userID, Map<String, ProductDTO> cart) {
        this.userID = userID;
        this.cart = cart;
    }

    public CartDTO(String userID, int quantiny, Map<String, ProductDTO> cart) {
        this.userID = userID;
        this.quantiny = quantiny;
        this.cart = cart;
    }

    public int getQuantiny() {
        return quantiny;
    }

    public void setQuantiny(int quantiny) {
        this.quantiny = quantiny;
    }
    

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Map<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }
    public void add(ProductDTO dto) {
        if (this.cart == null) {
            cart = new HashMap<>();
        }
        if (this.cart.containsKey(dto.getID())) {
            int quantity = this.cart.get(dto.getID()).getQuantity();
            dto.setQuantity(quantity + dto.getQuantity());
        }
        cart.put(dto.getID(), dto);
    }
    
    public void delete(String id) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
    
    public void update(ProductDTO dto) {
        if (this.cart != null) {
            if (this.cart.containsKey(dto.getID())) {
                this.cart.replace(dto.getID(), dto);
            }
        }
    }
}
