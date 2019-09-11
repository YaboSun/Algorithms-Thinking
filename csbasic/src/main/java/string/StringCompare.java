package string;

/**
 * @author YaboSun
 */
public class StringCompare {
    StringCompare a;

}

class Test {
    public static void main(String[] args) {
        StringCompare stringCompare1 = new StringCompare();
        StringCompare stringCompare2 = new StringCompare();

        boolean flag = stringCompare1.a == stringCompare2.a;
        boolean flag2 = (stringCompare1.a.equals(stringCompare2.a));

        System.out.println(flag);
        System.out.println(flag2);

    }
}
