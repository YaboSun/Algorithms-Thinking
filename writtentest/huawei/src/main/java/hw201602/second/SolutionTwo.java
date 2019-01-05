package hw201602.second;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author YBSun
 * Created in 2019-01-02
 *
 * 答案解析
 */
public class SolutionTwo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            char[] c = in.next().toCharArray();
            StringBuilder sb = new StringBuilder();
            Set<Character> set = new HashSet<Character>();
            for (char c1 : c) {
                if (set.add(c1))
                    sb.append(c1);
            }
            System.out.println(sb.toString());
        }
    }
}
