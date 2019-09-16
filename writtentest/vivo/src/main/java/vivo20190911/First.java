package vivo20190911;

import java.io.*;

/**
 * Welcome to vivo !
 */

public class First {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr );
        System.out.println(output);
    }

    private static int solution(String str) {

        // TODO Write your code here

        int maxCount1 = 0;
        int maxCount2 = 0;

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] == '0') {
                break;
            } else if (chars[i] == '(') {
                maxCount1 += 1;
            }
        }

        for (int j = chars.length - 1; j >= chars.length / 2; j--) {
            if (chars[j] == '0') {
                break;
            } else if (chars[j] == ')') {
                maxCount2 += 1;
            }
        }

        return Math.min(maxCount1, maxCount2);
    }
}