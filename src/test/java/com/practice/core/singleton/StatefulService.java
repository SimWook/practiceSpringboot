package com.practice.core.singleton;

public class StatefulService {

    //private int price; // 状態を維持するフィルド

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        //this.price = price; // ここが問題
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
