package ru.hawoline.testtask.model;

import java.util.ArrayList;

public class Product {

    private String name;
    private String imgUrl;
    private String description;

    private ArrayList<Integer> prices;
    private ArrayList<String> sizes;

    public Product(){

    }
    public Product(String name, String imgUrl, String description, ArrayList<Integer> prices, ArrayList<String> sizes) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.description = description;
        this.prices = prices;
        this.sizes = sizes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Integer> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<Integer> prices) {
        this.prices = prices;
    }

    public ArrayList<String> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<String> sizes) {
        this.sizes = sizes;
    }
}
