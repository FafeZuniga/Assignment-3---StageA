package com.assignment3;

public class customer {
    private String name;
    private int ID;
    private static int countC = 100;
    private boolean status;

    public customer(String name){
        this.name = name;
        this.ID = countC++;
    }

    public void displayCustomerDetails(){
        System.out.println("Title: " + getName());
        System.out.println("ID: " + getCustomerID());
    }

    public int getCustomerID() { return ID; }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("Customer: " + getName());
        System.out.println("ID: " + getCustomerID());
    }
}
