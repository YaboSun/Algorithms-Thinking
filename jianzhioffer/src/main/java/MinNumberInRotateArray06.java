import java.util.Arrays;

/**
 * @author YBSun
 * Created in 2019-02-05
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 */
public class MinNumberInRotateArray06 {

    // 直接排序 输出第一位不就可以了？
    // 解法没啥用
    public int minNumberInRotateArray1(int [] array) {
        Arrays.sort(array);
        return array[0];
    }

    // 实质上就是思考怎么排序效率高
    //
    public int minNumberInRotateArray2(int[] array) {
        return 0;
    }

}
