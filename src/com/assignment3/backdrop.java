package com.assignment3;

public class backdrop extends stock {

    double height;
    double width;
    double length;

    public backdrop(String type, String title,double height, double width){
        super (type,title);
        this.height = height;
        this.width = width;
    }
    public double calcPrice(){
        return 10.5;
    }
}
