package rank;

import org.junit.Test;

/**
 * 归并排序
 * 用到合并, 递归
 *
 * @author liuchuan
 * @date 2022/5/4 12:13 下午
 */
public class MergeSort {

    @Test
    public void test() {
        int[] arr = {2, 7, 9, 10, 3, 6, 8};
        sort(arr);
        RankUtil.print(arr);
    }

    public static void sort(int[] arr) {
        // 左边排好序, 右边排好序
        int left = 0;
        int right = arr.length - 1;

        sort(arr, left, right);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        // 这样写, 防止int越界
        int mid = left + (right - left) / 2;

        // 左边排好序
        sort(arr, left, mid);

        // 右边排好序
        sort(arr, mid + 1, right);

        // 合并
        merge(arr, left, mid + 1, right);
    }

    /**
     * 合并
     * 前提是左右两边都已经排好序
     *
     * @param arr
     * @param leftPoint
     * @param rightPoint
     * @param rightBound
     */
    private static void merge(int[] arr, int leftPoint, int rightPoint, int rightBound) {
        // 几个事情

        // 找到中间位置
        // 重新声明一个一样长的数组好放入
        // 声明指针

        int[] temp = new int[rightBound - leftPoint + 1];

        int mid = rightPoint - 1;
        // 前半段指针
        int i = leftPoint;
        // 后半段指针
        int j = rightPoint;

        // 新数组新指针
        int k = 0;

        // 遍历, 终止条件是防止两部分数组遍历完
        while (i <= mid && j <= rightBound) {
            // 谁小谁就放谁
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        // 放完后, 放剩下的那部分没有放完的数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= rightBound) {
            temp[k++] = arr[j++];
        }

        if (temp.length >= 0)
            System.arraycopy(temp, 0, arr, leftPoint, temp.length);
    }
}
