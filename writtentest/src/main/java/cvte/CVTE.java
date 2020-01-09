package cvte;

/**
 * @author Sun
 * @date 2020/1/6 19:35
 */
public class CVTE {

    public static void main(String[] args) {
        int[] ints = {7, 2, 5};
        int m = 3;
        System.out.println(splitArray(ints, m));
    }

    public static boolean guess(int[] nums, int mid, int m) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > mid) {
                m--;
                sum = nums[i];
                if (nums[i] > mid) {
                    return false;
                }
            } else {
                sum += nums[i];
            }
        }
        return m == 1;
    }

    public static int splitArray(int[] nums, int m) {
        int low = 0;
        int high = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            high += nums[i];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (guess(nums, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static String excelColIndexToStr(int columnIndex) {
        if (columnIndex <= 0) {
            return null;
        }
        String columnStr = "";
        columnIndex--;
        do {
            if (columnStr.length() > 0) {
                columnIndex--;
            }
            columnStr = ((char) (columnIndex % 26 + (int) 'A')) + columnStr;
            columnIndex = (int) ((columnIndex - columnIndex % 26) / 26);
        } while (columnIndex > 0);
        return columnStr;
    }
}
