/*
Author: Saikiran Nuthakki
E-mail: sqn5261@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 2
Due date: 2/14/2019
File: OrderItem.java
Purpose: Java application that implements an online specialty pizza shop
Compiler/IDE: IntelliJ IDEA
Operating system: Mac OS Sierra
Reference(s): Java 8 API - Oracle Documentation
//https://stackoverflow.com/questions/12524243/how-do-i-make-java-register-a-string-input-with-spaces/12524285
*/


package com.company;

public class OrderItem {
    int quantity, size;
    double price;
    String type;

    public OrderItem() {
        quantity = 0;
        size = 0;
        price = 0;
        type = "";
    }

    public OrderItem(String type, int size, int quantity, double price) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {   // gets user input for the quantity of pizzas

        return quantity;
    }
    public void setQuantity(int quantity) {  // setter, sets the quantity that was obtained from the user

        this.quantity = quantity;
    }
    public int getSize() { //gets user input for the size of pizza

        return size;
    }
    public void setSize(int size) { // setter, sets the size that was obtained from the user

        this.size = size;
    }
    public String getType() { //gets user input for the type of pizza

        return type;
    }
    public void setType(String type) { // setter, sets the type of pizza

        this.type = type;
    }
    public double getPrice() { //gets the price of pizza

        return price;
    }
    public void setPrice(double price) { // setter, sets the price of the pizza

        this.price = price;
    }
    public String toString() { // formatting helper

        return type + "\t        " +  size + "\t\t\t" + quantity + "\t\t\t" + " $ " + price;
    }

}
