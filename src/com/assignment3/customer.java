package com.assignment3;

public class customer {
    private String name;
    private int ID;
    private static int countC = 100;
    private stock[]hire = new stock[4];
    private int rentCount;

    public customer(String name){
        this.name = name;
        this.ID = countC++;
        this.rentCount = 0;
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
        for(int i=0;i<rentCount; i++){
            System.out.println("Currently rented item ID: " + hire[i].getStockID());}
    }
    public boolean rentStock(stock obj) {
        hire[rentCount]=obj;
        obj.changeStatus();
        rentCount++;
        return true;
    }
}
