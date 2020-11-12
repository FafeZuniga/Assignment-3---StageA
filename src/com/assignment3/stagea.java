package com.assignment3;

import java.util.Scanner;

public class stagea {
    static Scanner sc;
    int numStock = 0;
    int numCustomer = 0;
    stock[] stockCollection;
    customer[] customers;

    public stagea() {
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        stagea app = new stagea();
        int currentStock = 0;
        int currentCustomer = 0;
        app.asksForStock();
        app.asksForCustomer();
        app.customers = new customer[app.numCustomer];
        app.stockCollection = new stock[app.numStock];
        while (true) {
            app.printMenu();
            switch (app.returnChoice()) {
                //Option 1
                case 1:
                    if (currentStock == app.stockCollection.length) {
                        System.out.println("Error - You cannot add any more stock.\n");
                        break;
                    }else {
                        String type = app.stockType();
                        String title = app.stockTitle();


                        app.stockCollection[currentStock] = new stock(type, title);
                    }
                    currentStock++;
                   // stock.ID++;
                    break;
                // Option 2
                case 2:
                    if (currentCustomer == app.stockCollection.length) {
                        System.out.println("Error - You cannot add any more customers.\n");
                        break;
                    }else {
                        String name = app.customerName();
                        app.customers[currentCustomer] = new customer(name);
                    }
                    currentCustomer++;
                    break;
                // Option 3
                case 3:
                    String target;
                    customer a;
                    a = null;
                    String name;
                    System.out.println("Enter the name of the customer: ");
                    sc.nextLine();
                    target = sc.nextLine();
                    for (int i = 0; i < app.customers.length && a == null; i++) {
                        name = app.customers[i].getName();
                        if (name.equalsIgnoreCase(target)) {
                            String target1;
                            customer b;
                            a = null;
                            String stockName;
                            System.out.println("Enter the stock you would like to hire: ");
                            sc.nextLine();
                            target1 = sc.nextLine();
                        }
                    }
                    break;
                //Option 4
                case 4:

                    break;
                case 5:
                    for (int i = 0; i < app.customers.length; i++) {
                        System.out.println("==============Current Customer==============");
                        app.customers[i].displayDetails();
                    }
                    break;
                case 6:
                    for (int i = 0; i < app.stockCollection.length; i++) {
                        System.out.println("==============Current Stock==============");
                        app.stockCollection[i].displayDetails();
                    }
                    break;
                case 7:
                    app.searchStock();
                    break;
                //exits the program
                case 8:
                    System.out.println("You have quit the program\r\n");
                    System.exit(0);
                    break;
                //Error Message/menu validation
                default:
                    System.out.println("\nYou have entered an invalid selection, please try again \n");
            }

        }
    }

    private String customerName() {
        System.out.println("Please enter the name of the customer");
        String name = sc.next();
        return name;
    }
    public void searchStock() {
        String target;
        stock a;
        a = null;
        String name;
        System.out.println("Enter title of stock: ");
        sc.nextLine();
        target = sc.nextLine();
        for (int i = 0; i < stockCollection.length && a == null; i++) {
            name = stockCollection[i].getStockTitle();
            if (name.equalsIgnoreCase(target)) {
                a = stockCollection[i];
                a.displayDetails();
            }
        }
        if (a == null) {
            System.out.println("Error - " + target + " not found!");
        }
    }

    private void asksForCustomer() {
        boolean isNumber;
        while (isNumber = true) {
            System.out.println("Please enter the number of Customers (MAX 3)");
            if (sc.hasNextInt()) {
                numCustomer = returnChoice();
                break;
            } else {
                System.out.println("Your input is invalid");
                isNumber = false;
                sc.next();
            }
        }
    }
    
    private String stockTitle() {
        System.out.println("Please enter the title of the stock");
        String title = sc.next();
        return title;
    }


    private String stockType() {
        System.out.println("Please enter the type of stock (Backdrop/Prop/Costume)");
        String type = sc.next();
        return type;
    }

    public void printMenu() {
        //Welcomes the user to the application and display menu
        String mainMenu = ("                 MENU: \n" +
                "---------------------------------------\n" +
                "[1] Add stock item\n" +
                "[2] Add customer\n" +
                "[3] Hire a stock item\n" +
                "[4] Return stock item\n" +
                "[5] Display all customer information\n" +
                "[6] Display all stock information\n" +
                "[7] Display specific stock information\n" +
                "[8] Exit program\n" +
                "Please make your selection now (1-5) ");
        System.out.println(mainMenu);
    }
    public int returnChoice() { return sc.nextInt();}

    public String stockName() {
        System.out.println("Please enter the name of the stock");
        String title = sc.next();
        return title;
    }
    public void asksForStock() {
        boolean isNumber;
        while (isNumber = true) {
            System.out.println("Please enter the number of stock (MAX 5)");
            if (sc.hasNextInt()) {
                numStock = returnChoice();
                break;
            } else {
                System.out.println("Your input is invalid");
                isNumber = false;
                sc.next();
            }
        }
    }

}
