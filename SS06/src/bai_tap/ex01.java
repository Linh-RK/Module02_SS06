package bai_tap;

import java.util.Arrays;

public class ex01 {
    public static void main(String[] args) {
        String string= "   Hello World   ";
        String string2= "!";
        System.out.println(string.isEmpty());
        System.out.println(string.trim());
        string = string.trim();
        System.out.println(string.equals("hello world"));
        System.out.println(string.equalsIgnoreCase("hello world"));
        System.out.println(Arrays.toString(string.split(" ")));
        System.out.println(string.concat(string2));
        System.out.println(string.contains("ll"));
        System.out.println(string.toUpperCase());
        System.out.println(string.toLowerCase());
        System.out.println(string.replace("Hello","Hi"));
        System.out.println(string.length());
    }
}
