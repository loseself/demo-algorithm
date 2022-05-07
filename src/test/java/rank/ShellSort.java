package rank;

import org.junit.Test;

/**
 * 希尔排序
 * 有间隙的插入排序
 *
 * @author liuchuan
 * @date 2022/5/4 12:13 下午
 */
public class ShellSort {

    @Test
    public void test() {
        int[] arr = {9, 7, 10, 2, 3, 6, 8, 5, 11, 1, 4};
        sort(arr);
        RankUtil.print(arr);
    }

    public static void sort(int[] arr) {
        knuth(arr);
    }

    public static void nHalves(int[] arr) {
        // 怎么缩小间隔, 每次缩小1倍, 直到为1, 为1就相当于一个一个的走一遍
        for (int gap = arr.length >> 1; gap > 0; gap >>= 1) {
            insert(arr, gap);
        }
    }

    public static void knuth(int[] arr) {
        // 怎么取到最合适间隔
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }

        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            insert(arr, gap);
        }
    }

    private static void insert(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            // 当前要插入的数
            int tmp = arr[i];

            // 当前要插入的数的位置
            int j = i;

            // 终止条件
            while (j > gap - 1 && tmp < arr[j - gap]) {
                // 交换, 只把大的移到右边
                arr[j] = arr[j - gap];
                // 指针向左移动
                j -= gap;
            }

            if (j != i) {
                arr[j] = tmp;
            }
        }
    }

}
