package com.assignment3;

public class prop extends stock {

    double height;
    double width;
    double length;

    public prop(String type, String title,double height, double width, double length){
        super (type,title);
        this.height = height;
        this.width = width;
        this.length = length;
    }
    public double calcPrice(){
        return 10.5;
    }
}
