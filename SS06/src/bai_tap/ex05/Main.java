package bai_tap.ex05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        product.inputData(scanner);
        product.displayData();
    }
}
