package hw2016.second;

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
            StringBuffer sb = new StringBuffer();
            Set<Character> set = new HashSet<Character>();
            for(int i = 0;i<c.length;i++){
                if(set.add(c[i]))
                    sb.append(c[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
