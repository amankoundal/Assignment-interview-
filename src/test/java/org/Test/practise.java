package org.Test;

import java.util.Arrays;

public class practise {
    public static void main(String[] args) {
        String a= "Total Records : 395";
       String[] b= (a.split(":"));
       String c= b[1].trim();
        System.out.println(c);
    }
}
