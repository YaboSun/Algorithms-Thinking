package nowcoder01;

/**
 * @author YaboSun
 *
 * 排行第一解法
 */
public class SolutionTwo {
    public boolean Find(int [][] array,int target) {
        int len = array.length-1;
        int i = 0;
        while((len >= 0) && (i < array[0].length)) {
            if(array[len][i] > target){
                len--;
            } else if(array[len][i] < target) {
                i++;
            } else{
                return true;
            }
        }
        return false;
    }
}
