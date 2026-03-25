package com.cornejo.test.map;

public class MyHashMapTest {

    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();

        myHashMap.put(1, "Bob");
        myHashMap.put(2, "Pat");
        myHashMap.put(3, "Jos");
        myHashMap.put(4, "Bet");
        myHashMap.put(5, "Col");
        myHashMap.put(6, "Bob");
        myHashMap.put(7, "Pat");
        myHashMap.put(8, "Jos");
        myHashMap.put(9, "Bet");
        myHashMap.put(10, "Col");
        myHashMap.put(11, "Bob");
        myHashMap.put(12, "Pat");
        myHashMap.put(13, "Jos");
        myHashMap.put(14, "Bet");
        myHashMap.put(15, "Col");
        myHashMap.put(16, "Bob");
        myHashMap.put(17, "Pat");
        myHashMap.put(18, "Jos");
        myHashMap.put(19, "Bet");
        myHashMap.put(20, "Col");

        System.out.println(myHashMap.get(3));

        myHashMap.put(3, "Three");

        System.out.println(myHashMap.get(3));
    }
}
