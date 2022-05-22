package rank;

/**
 * @author liuchuan
 * @date 2022/5/4 12:17 下午
 */
public class RankUtil {
    public static void print(int[] arr) {
        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
