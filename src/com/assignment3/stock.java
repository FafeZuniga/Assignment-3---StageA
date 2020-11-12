package com.assignment3;

public class stock {

    private String title;
    public static int ID = 1000;
    private String type;

    public stock(String type, String title, int id) {
        this.title = title;
        this.ID = ID;
        this.type = type;
    }

    public void displayDetails(){
        System.out.println(type + "/" + getStockTitle());
        System.out.println("ID: " + getStockID());
    }

    public int getStockID() { return ID; }

    public String getStockTitle() { return title; }
}

