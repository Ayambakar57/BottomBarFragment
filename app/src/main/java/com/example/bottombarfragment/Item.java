package com.example.bottombarfragment;

public class Item {
    String img, name;

    public Item ( String img, String name){
        this.img = img;
        this.name = name;

    }

    public void setImg(String img){
        this.img = img;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){ return name;}

    public String getImg(){
        return img;
    }
}
