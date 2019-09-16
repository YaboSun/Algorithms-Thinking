package vivo20190911;

/**
 * @author YaboSun
 */
import java.io.*;

/**
 * Welcome to vivo !
 */

public class Third {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {

        // TODO Write your code here
        int max = 0;
        for (int i : input) {
            max = Math.max(i, max);
        }

        int[] index = new int[max + 1];

        for (int i : input) {
            index[i] += 1;
        }

        int ret = 0;

        for (int i : index) {
            ret += i * i;
        }
        return ret;

    }
}
