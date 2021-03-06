package com.assignment3;

import java.util.Scanner;

/*
This program allows a user to enter
different types of stock and also add customers.
Each customer can hire or return the different type of stock.
*/
public class stageb {
    static Scanner sc;
    int numStock = 0;
    int numCustomer = 0;
    stock[] stockCollection;
    customer[] customers;


    public stageb() {
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        stageb app = new stageb();
        int currentStock = 0;
        int currentCustomer = 0;
        app.asksForStock();
        app.asksForCustomer();
        app.customers = new customer[app.numCustomer];
        app.stockCollection = new stock[app.numStock];
        while (true) {
            app.printMenu();
            switch (app.returnChoice()) {
                //Option 1 - Adds a stock item
                case 1:
                    if (currentStock == app.stockCollection.length) {
                        System.out.println("Error - You cannot add any more stock.\n");
                        break;
                    } else {
                        String type = app.stockType();
                        if (type.equalsIgnoreCase("Prop")) {
                            String title = app.stockTitle();
                            System.out.println("Please enter the height, width and length");
                            double height = sc.nextDouble();
                            double width = sc.nextDouble();
                            double length = sc.nextDouble();
                            app.stockCollection[currentStock] = new prop(type, title, height, width, length);
                        }
                        if (type.equalsIgnoreCase("Backdrop")) {
                                String title = app.stockTitle();
                                System.out.println("Please enter the height, width");
                                double height = sc.nextDouble();
                                double width = sc.nextDouble();
                                app.stockCollection[currentStock] = new backdrop(type, title, height, width);
                            }
                                if (type.equalsIgnoreCase("Costume")) {
                                    String title = app.stockTitle();
                                    System.out.println("Please enter the genre, size and category (in respective order)");
                                    String genre = sc.nextLine();
                                    String size = sc.nextLine();
                                    String category = sc.nextLine();
                                    app.stockCollection[currentStock] = new costume(type, title, genre, size, category);
                                }
                        currentStock++;
                            }
                    break;
                // Option 2 - Adds a customer
                case 2:
                    if (currentCustomer == app.stockCollection.length) {
                        System.out.println("Error - You cannot add any more customers.\n");
                        break;
                    }else {
                        String name = app.customerName();
                        app.customers[currentCustomer] = new customer(name);
                        currentCustomer++;
                    }

                    break;
                // Option 3 - Allows a customer to hire an item
                case 3:
                    String target;
                    customer a;
                    a = null;
                    String name;
                    System.out.println("Enter the name of the customer: ");
                    sc.nextLine();
                    target = sc.nextLine();
                    for (int i = 0; i < currentCustomer && a == null; i++) {
                        if (app.customers[i].getName().equalsIgnoreCase(target)) {
                            String target1;
                            stock b;
                            String stockName;
                            System.out.println("Enter the stock you would like to hire: ");
                            target1 = sc.nextLine();
                            for(int j=0; j<currentStock; j++){
                                if(app.stockCollection[j].getStockTitle().equalsIgnoreCase(target1)){
                                    if(app.stockCollection[j].getStatus()==false){
                                        System.out.println("Item not available");
                                    }else{
                                    app.customers[i].rentStock(app.stockCollection[j]);}
                                }
                            }
                        }
                    }
                    break;
                //Option 4 - Allows a customer to return an item
                case 4:
                    String target2;
                    stock c;
                    String stockName;
                    sc.nextLine();
                    System.out.println("Enter the stock you would like to return: ");
                    target2 = sc.nextLine();
                    for(int j=0; j<currentStock; j++) {
                        if (app.stockCollection[j].getStockTitle().equalsIgnoreCase(target2)) {
                            if (app.stockCollection[j].getStatus() == true) {
                                System.out.println("Item is currently available - Item return not possible");
                                break;
                            } else {
                                System.out.println("Enter which customer would like to return the item");
                                String returnCustomer = sc.nextLine();
                                for (int i = 0; i < currentCustomer; i++) {
                                    if (app.customers[i].getName().equalsIgnoreCase(returnCustomer)) {
                                        boolean releaseStatus = app.customers[i].releaseStock(app.stockCollection[j]);
                                        if (releaseStatus) {
                                            app.stockCollection[j].changeStatus();
                                            System.out.println("Item has now been returned - Thanks!");
                                        } else {
                                            System.out.println("Item not rented by this customer!");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                    //Option 5 - Displays all details of every customer in the system
                case 5:
                    for (int i = 0; i < currentCustomer; i++) {
                        System.out.println("==============Current Customer==============");
                        app.customers[i].displayDetails();
                    }
                    break;
                //Option 6 - Displays all details of every stock item in the system
                case 6:
                    for (int i = 0; i < currentStock; i++) {
                        System.out.println("==============Current Stock==============");
                        app.stockCollection[i].displayDetails();
                    }
                    break;
                //Option 7 - Searches for a specific stock item in the system
                case 7:
                    app.searchStock();
                    break;
                //Option 8 - Searches for a specific customer in the system
                case 8:
                    app.searchCustomer();
                    break;
                //Option 9 - Exits the program
                case 9:
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
    public void searchCustomer() {
        String target;
        customer a;
        a = null;
        String name;
        System.out.println("Enter customer name: ");
        sc.nextLine();
        target = sc.nextLine();
        for (int i = 0; i < customers.length && a == null; i++) {
            name = customers[i].getName();
            if (name.equalsIgnoreCase(target)) {
                a = customers[i];
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
        String title = sc.nextLine();
        return title;
    }


    private String stockType() {
        System.out.println("Please enter the type of stock (Backdrop/Prop/Costume)");
        String type = sc.nextLine();
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
                "[8] Display specific customer information\n" +
                "[9] Exit program\n" +
                "Please make your selection now (1-5) ");
        System.out.println(mainMenu);
    }
    public int returnChoice() {      return Integer.parseInt(sc.nextLine());}

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
