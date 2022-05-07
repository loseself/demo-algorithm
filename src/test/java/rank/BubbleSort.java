package rank;

import org.junit.Test;

/**
 * @author liuchuan
 * @date 2022/5/1 10:33 下午
 */
public class BubbleSort {

    @Test
    public void test() {
        int[] arr = {7, 9, 10, 2, 3, 6, 8, 5};
        for (int i = arr.length - 1; i > 0; i--) {
            findMax(arr, i);
        }

        RankUtil.print(arr);
    }

    private void findMax(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i + 1]) {
                RankUtil.swap(arr, i, i + 1);
            }
        }
    }

}
