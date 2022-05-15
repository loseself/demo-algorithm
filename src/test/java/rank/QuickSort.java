package rank;

import org.junit.Test;

import java.util.Random;

/**
 * @author liuchuan
 * @date 2022/5/10 10:12 上午
 */
public class QuickSort {

    @Test
    public void test() {
        int[] arr = {3, 8, 7, 2, 10};
        sort(arr);
        RankUtil.print(arr);
    }

    public static int[] sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void sort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            sort(nums, l, pos - 1);
            sort(nums, pos + 1, r);
        }
    }

    public static int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        // 这边再优化, 把最后一个数随机替换一下数组中的任意一个数
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public static int partition(int[] nums, int l, int r) {
        // 轴, 最右边的数
        int pivot = nums[r];

        // 分区标志, 从最左边开始
        int flag = l;

        // cursor游标, 从左到右, 把小于轴的, 放在分区标志的左边
        // 大于轴的, 放在分区标志的右边
        for (int cursor = l; cursor <= r - 1; ++cursor) {
            if (nums[cursor] < pivot) {
                if (flag != cursor) {
                    swap(nums, flag, cursor);
                }

                flag++;
            }
        }

        if (flag < r) {
            swap(nums, flag, r);
        }
        return flag;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
