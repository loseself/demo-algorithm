package practice;

/**
 * @author liuchuan
 * @date 2022/5/17 10:00 上午
 */
public class SortColor {

    public void sort(int[] nums) {
        int n = nums.length;

        // 一个指针, 先排0, 然后排1
        int p = 0;

        for (int i = 0; i < n; i++) {
            // 等于0的, 交换p和i的位置
            if (nums[i] == 0) {
                swap(nums, i, p);
                p++;
            }
        }

        for (int i = p; i < n; i++) {
            // 等于1的, 交换p和i的位置
            if (nums[i] == 1) {
                swap(nums, i, p);
                p++;
            }
        }
    }

    /**
     * 双指针
     *
     * @param nums
     */
    public void sort2(int[] nums) {
        int n = nums.length;

        // p0指针, 排0
        int p0 = 0;
        // p1指针, 排1
        int p1 = 0;

        for (int i = 0; i < n; i++) {
            // 等于0的, 交换p和i的位置
            if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            }

            if (nums[i] == 0) {
                // 此时可能会把p0在的位置是1的元素换出去
                swap(nums, i, p0);

                if (p0 < p1) {
                    // p0 < p1, p0可能是1
                    // 此时要把换出去的1, 再换给p1
                    swap(nums, i, p1);
                }

                p0++;
                p1++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
