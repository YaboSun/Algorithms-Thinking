package ali0326;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class FirstTest {


    public static void main(String[] args) {
        First f = new First();
        String str = "192.168.0.1";
        f.isIPAddress(str);
    }
}