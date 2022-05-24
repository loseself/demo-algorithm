package rank;

import org.junit.Test;

import java.util.Arrays;

/**
 * 基数排序
 * 每个位数的排序, 基于计数排序
 *
 * @author liuchuan
 * @date 2022/5/1 10:33 下午
 */
public class RadixSort {

    @Test
    public void test() {
        int[] arr = {7, 9, 10, 2, 3, 10, 6, 8, 1, 5, 0};

        sort(arr);
        RankUtil.print(arr);

    }

    /**
     * 使用累加数组
     *
     * @param arr
     * @return
     */
    public static void sort(int[] arr) {
        // 计数数组, 0-9
        int[] count = new int[10];

        // 结果数组
        int[] result = new int[arr.length];

        // 遍历最长位数, 这里选个3
        for (int i = 0; i < 2; i++) {
            int division = (int)Math.pow(10, i);

            // 计数
            for (int j : arr) {
                // 当前位数取模
                int num = j / division % 10;
                count[num]++;
            }

            // 累加, 第二个下标开始, 对应的值等于前面所有值的和
            for (int k = 1; k < count.length; k++) {
                count[k] = count[k] + count[k - 1];
            }

            // 原数组倒着开始遍历
            for (int l = arr.length - 1; l >= 0; l--) {
                int current = arr[l] / division % 10;
                // 结果数组的下标
                // count自己也要减, 因为当前元素归位后, 下一个相同元素知道自己在前一个位置
                int resultIndex = --count[current];
                result[resultIndex] = arr[l];
            }

            // 把result拷贝到arr里, 再进行下一位数的排序
            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);
        }

    }
}
