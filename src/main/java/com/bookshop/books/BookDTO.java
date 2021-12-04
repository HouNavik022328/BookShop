/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.books;

/**
 *
 * @author VODUCMINH
 */
public class BookDTO {
    private String ID;
    private String name;
    private String description;
    private String author;
    private int price;
    private String createDate;
    private String image;
    private int categoryID;
    private int typeID;
    private int quantity;

    public BookDTO(String ID, String name, String description, String author, int price, String createDate, String image, int categoryID, int typeID, int quantity) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.author = author;
        this.price = price;
        this.createDate = createDate;
        this.image = image;
        this.categoryID = categoryID;
        this.typeID = typeID;
        this.quantity = quantity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
