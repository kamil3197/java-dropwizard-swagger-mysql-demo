package org.kainos.ea.cli;


public class Product implements Comparable<Product> {
    public Product(int productID, String description, String name, Double price) {
        this.productID = productID;
        this.description = description;
        this.name = name;
        this.price = price;
    }

    int productID;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    String description;
    String name;
    Double price;

    @Override
    public int compareTo(Product product) {
        return Double.compare(this.getPrice(), product.getPrice());
    }
    @Override
    public String toString(){
        return "Product name:" + this.getName() + ", product price: $" + this.getPrice();
    }
}