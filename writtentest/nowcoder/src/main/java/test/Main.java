package test;

import java.util.Arrays;
import java.util.List;
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

        int[] array = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(1,2);
        System.out.println(list);
    }
}
