package test;

import java.util.Scanner;

/**
 * @author YaboSun
 */
public class Main {
    public static void main(String[] args) {
        int date;
        int price;
        int priceDownNum;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            date = sc.nextInt();
            priceDownNum = (int)(Math.sqrt(2 * date + 0.25) - 1.5);
            price = date - 2 * priceDownNum;
            System.out.println(price);
        }
    }
}
