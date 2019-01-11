package doublepointer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class LeetCode524Test {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");

        LeetCode524 leetCode524 = new LeetCode524();
        leetCode524.findLongestWord(s, d);
    }

}