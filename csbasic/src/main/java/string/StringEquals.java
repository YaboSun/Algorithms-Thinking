package string;

/**
 * @author YaboSun
 */
public class StringEquals {

    public static void main(String[] args) {
        stringEquals();
    }
    private static void stringEquals() {
        String string1 = "hello";
        String string2 = "hello";
        char[] string3 = {'h', 'e', 'l', 'l', 'o'};
        char[] string4 = {'h', 'e', 'l', 'l', 'o'};
        String string = "hello";
        String string0 = "hello";
        int result1 = string1 == string2 ? 1 : 0;
        int result2 = string3 == string4 ? 1 : 0;

        System.out.println(result1);
        System.out.println(result2);
    }

}
