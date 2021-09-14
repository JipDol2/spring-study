package com.example.project.singleton;

public class StatefulService {

    private int price;

    public void order(String name,int price){
        System.out.println("name = "+name + " price = "+price);
        this.price = price; //여기가 문제
    }

    /***
     * void가 아닌 int로 선언해서 전역이 아닌 지역변수로 선언해서 return 시켜주면 된다.
     * public int order(String name,int price){
     *         System.out.println("name = "+name + " price = "+price);
     *         this.price = price; //여기가 문제
     *         return price;
     *     }
    */

    public int getPrice(){
        return this.price;
    }
}
