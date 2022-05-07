package rank;

/**
 * @author liuchuan
 * @date 2022/4/25 9:58 下午
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};
        sort(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }

            RankUtil.swap(arr, i, minPos);
        }

        RankUtil.print(arr);
    }

}
