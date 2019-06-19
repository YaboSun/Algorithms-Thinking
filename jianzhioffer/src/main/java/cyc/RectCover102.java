package cyc;

/**
 * @author transwarp
 * @date 19-6-19
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover102 {

    /**
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        // 先通过题意可以得到当n =1，2时候的解
        // 然后可以归纳出满足斐波那契公式
        int numOfKinds = 0;

        if (target <= 2) {
            return target;
        }

        int pre1 = 2;
        int pre2 = 1;

        for (int i = 3; i <= target; i++) {
            numOfKinds = pre1 + pre2;
            pre2 = pre1;
            pre1 = numOfKinds;
        }

        return numOfKinds;
    }
}

