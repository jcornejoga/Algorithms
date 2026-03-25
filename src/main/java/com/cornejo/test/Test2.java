package com.cornejo.test;

import org.apache.commons.lang3.StringUtils;

public class Test2 {

    public static void main(String[] args) {
        String str1 = null;

        String str2 = "value";

        testMethod(str1);
        testMethod(str2);
    }

    public static void testMethod(String str) {
        String value = StringUtils.isNotBlank(str) ? str : null;

        System.out.println(value);
    }
}
