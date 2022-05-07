package rank;

import org.junit.Test;

/**
 * @author liuchuan
 * @date 2022/5/4 12:13 下午
 */
public class InsertionSort {

    @Test
    public void test() {
        int[] arr = {9, 7, 10, 2, 3, 6, 8, 5};
        sort(arr);
        RankUtil.print(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 现在假如有1张牌, 抓了一张, 开始从右向左比较, 然后插入

            // 记录要插入的数据
            int tmp = arr[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                // 从右开始向左比较, 大于当前要插入的数, 就向右移动一位
                arr[j] = arr[j - 1];
                // 然后指针向左移动一位
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                // 直到移动不了, 当前位置已经移动过了
                // 直接覆盖进去就好
                arr[j] = tmp;
            }
        }
    }

}
