package rank;

import org.junit.Test;

/**
 * @author liuchuan
 * @date 2022/5/1 10:33 下午
 */
public class CountSort {

    @Test
    public void test() {
        int[] arr = {7, 9, 10, 2, 3, 10, 6, 8, 1, 5, 0};

        int[] result = sort2(arr);
        RankUtil.print(result);

    }

    public static int[] sort(int[] arr) {
        // 计数数组, 0-10
        int[] count = new int[11];
        // 开始计数
        for (int i : arr) {
            count[i]++;
        }

        RankUtil.print(count);

        // 结果数组
        int[] result = new int[arr.length];

        for (int i = 0, j = 0; i < count.length; i++) {
            // 当count的下标对应的值等于0, 换下标
            // 这里不稳定, 因为count从后向前减少的
            // result从前向后开始排的, 反了, 所以不稳定
            while (count[i]-- > 0) {
                result[j++] = i;
            }
        }

        return result;
    }

    /**
     * 使用累加数组
     *
     * @param arr
     * @return
     */
    public static int[] sort2(int[] arr) {
        // 计数数组, 0-10
        int[] count = new int[11];
        // 开始计数
        for (int i : arr) {
            count[i]++;
        }

        // 累加, 第二个下标开始, 对应的值等于前面所有值的和
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        RankUtil.print(count);

        int[] result = new int[arr.length];
        // 原数组倒着开始遍历
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            // 结果数组的下标
            // count自己也要减, 因为当前元素归位后, 下一个相同元素知道自己在前一个位置
            int resultIndex = --count[current];
            RankUtil.print(count);

            result[resultIndex] = current;
        }

        return result;
    }
}
