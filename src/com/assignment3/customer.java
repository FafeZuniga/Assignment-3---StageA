package com.assignment3;

public class customer {
    private String name;
    private int IDC;

    public customer(String name, int IDC){
        this.name = name;
        this.IDC = IDC;
    }

    public void displayCustomerDetails(){
        System.out.println("Title: " + getName());
        System.out.println("ID: " + getCustomerID());
    }

    public int getCustomerID() { return IDC; }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("Customer: " + getName());
        System.out.println("ID: " + getCustomerID());
    }
}
