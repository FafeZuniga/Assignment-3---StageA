package com.assignment3;

 public class costume extends stock {

        String genre;
        String size;
        String category;

        public costume(String type, String title,String genre, String size, String category){
            super (type,title);
            this.genre = genre;
            this.size = size;
            this.category = category;
        }
        public double calcPrice(){
            return 10.5;
        }
    }

