package telegram20190910;

import java.util.Scanner;

/**
 * @author YaboSun
 */
public class Third {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.length() <= 3) {
            if (line.length() <= 1) {
                return;
            } else {
                System.out.println(line.charAt(1));
                return;
            }
        }
        String s = line.substring(1, line.length() - 1);
        String[] strings = s.split(",");

        int[] arr = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            arr[i] = new Integer(strings[i]);
        }
        System.out.println(maxSequence(arr, arr.length));
    }

    private static int maxSequence(int[] arr, int len) {
        int maxsum, maxTmp;

        maxsum = maxTmp = arr[0];

        for (int i = 1; i < len; i++) {
            if (maxTmp <= 0) {
                maxTmp = arr[i];
            } else {
                maxTmp += arr[i];
            }
            if (maxTmp > maxsum) {
                maxsum = maxTmp;
            }
        }
        return maxsum;
    }
}
