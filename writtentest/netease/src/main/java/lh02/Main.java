package lh02;

import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-04-07
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] strings = str.split(",");
        char[] chars1 = strings[0].toCharArray();
        char[] chars2 = strings[1].toCharArray();

        int count = 0;
        int[] num = new int[chars1.length];
        for (int i = 0; i < chars1.length; i++) {
            int a = (int) chars1[i];
            int b = (int) chars2[i];

            num[i] = a - b;
        }

        for (int i = 0; i < num.length; i++) {
            if (Math.abs(num[i]) == 1) {
                for (int j = i + 1; j < chars1.length; j++) {
                    if (num[j] == -num[i]) {
                        if (chars1[i] == chars2[j] && chars1[j] == chars2[i]){
                            count += 1;
                            num[i] = 0;
                            num[j] = 0;
                            break;
                        } else if (j == chars1.length - 1){
                            count += 1;
                        }
                    }
                }
            } else {
                count = count + num[i];
            }
        }
        System.out.println(count);
    }
}
