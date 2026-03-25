package com.cornejo.test;

public class BooleanTest {

    public static void main(String[] args) {
        Boolean flag = null;

        method(flag);

    }

    public static void method(Boolean flag) {
        if (flag == null || Boolean.FALSE.equals(flag)) {
            System.out.println("flag is different from null");
        } else {
            System.out.println("flag is equal to null");
        }
        System.out.println("value " + flag);
    }

}
