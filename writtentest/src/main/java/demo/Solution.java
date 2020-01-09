package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sun
 * @date 2020/1/9 10:22
 */
public class Solution {

    public static void main(String[] args) {
        getIntersectPoints(5, 0, 8, 2, 6, 0, 7, 4);
    }

    private static List<Integer[]> getIntersectPoints(int xa0, int ya0, int xa1, int ya1,
                                                      int xb0, int yb0, int xb1, int yb1) {
        List<Integer[]> ret = new ArrayList<>(2);
        Integer[] point1 = new Integer[2];
        Integer[] point2 = new Integer[2];
        int wa = xa1 - xa0;
        int ha = ya1 - ya0;

        int wb = xb1 - xb0;
        int hb = yb1 - yb0;

        int xa3 = (xa1 + xa0) / 2;
        int ya3 = (ya0 + ya1) / 2;
        int xb3 = (xb1 + xb0) / 2;
        int yb3 = (yb0 + yb1) / 2;

        if (Math.abs(xb3 - xa3) <= wa / 2 + wb / 2 && Math.abs(yb3 - ya3) <= ha / 2 + hb / 2) {
            int xc1 = Math.max(xa0, xb0);
            int xc2 = Math.min(xa1, xb1);
            int yc2 = Math.min(ya1, yb1);

            point1[0] = xc1;
            point1[1] = yc2;
            point2[0] = xc2;
            point2[1] = yc2;

            ret.add(point1);
            ret.add(point2);
        }
        return ret;
    }
}
