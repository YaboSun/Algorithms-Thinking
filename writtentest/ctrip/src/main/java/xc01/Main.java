package xc01;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author YBSun
 * Created in 2019-04-08
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        boolean flag = false;
        for (int i = 0; i < split.length; i++) {
            for (int j = i + 1; j < split.length; j++) {
                if (split[i].equals(split[j])) {
                    flag = true;
                    break;
                }
            }
        }

        System.out.println(flag);
    }

}
