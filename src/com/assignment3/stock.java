package com.assignment3;

public class stock {

    private String title;
    public int ID;
    private String type;
    static private int count = 1000;
    private boolean status;

    public stock(String type, String title) {
        this.title = title;
        this.ID = count++;
        this.type = type;
    }

    public void displayDetails(){
        System.out.println(type + "/" + getStockTitle());
        System.out.println("ID: " + getStockID());
    }

    public int getStockID() { return ID; }

    public String getStockTitle() { return title; }
}

