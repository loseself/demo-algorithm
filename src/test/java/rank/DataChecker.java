package rank;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author liuchuan
 * @date 2022/5/5 4:34 下午
 */
public class DataChecker {

    @Test
    public void testTime() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int[] arr = generateRandomArray();
            ShellSort.nHalves(arr);
        }

        System.out.println("2分之n的间隙, 时间: " + (System.currentTimeMillis() - start) + "ms");

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int[] arr = generateRandomArray();
            ShellSort.knuth(arr);
        }

        System.out.println("knuth间隙, 时间: " + (System.currentTimeMillis() - start2) + "ms");
    }

    @Test
    public void test() {
        boolean same = true;

        for (int times = 0; times < 500; times++) {
            int[] arr = generateRandomArray();
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);

            Arrays.sort(arr);
            //        InsertionSort.sort(arr2);
            //        ShellSort.knuth(arr2);
            MergeSort.sort(arr2);

            for (int i = 0; i < arr2.length; i++) {
                if (arr[i] != arr2[i]) {
                    same = false;
                    break;
                }
            }
        }

        System.out.println(same ? "right" : "wrong");
    }

    private int[] generateRandomArray() {
        Random r = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10000);
        }
        return arr;
    }

}
