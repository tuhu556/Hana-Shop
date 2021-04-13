/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin
 */
public class ProductDTO {
    private String ID;
    private String name;
    private int quantity;
    private float price;
    private String description;
    private String category;
    private String image;
    private boolean status;
    private String createDate;
    private String updateDate;

    public ProductDTO() {
    }

    public ProductDTO(String ID, String name, int quantity, float price, String description, String category, String image, boolean status, String createDate, String updateDate) {
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    

    public ProductDTO(String ID, String name, int quantity, float price, String description, String category, String image, boolean status) {
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.status = status;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

}
