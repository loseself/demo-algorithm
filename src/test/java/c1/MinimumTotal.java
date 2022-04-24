package c1;

import java.util.List;

/**
 * @author liuchuan
 * @date 2022/4/24 11:19
 */
public class MinimumTotal {

    /**
     * 动态规划解法1
     *
     * @param triangle 三角
     * @return 最短路径
     */
    private int solution1(List<List<Integer>> triangle) {
        // 声明数组
        int triangleSize = triangle.size();
        int[][] f = new int[triangleSize][triangleSize];
        // 第一行
        f[0][0] = triangle.get(0).get(0);

        // 第二行开始, 下标是1
        for (int i = 1; i < triangleSize; i++) {
            // 最左侧元素
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);

            // 中间, 这里的j, i, 代表这一行的个数的下标
            // 所以 j是从第二个元素开始, j < i, 是到最右侧的前一个元素结束
            //   1
            //  2 3
            // 4 5 6, i = 2, j取1
            for (int j = 1; j < i; j++) {
                // 上图中, 元素5, 上面就是2和3, 2和3的路径获取最小值后, 加5
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }

            // 最右侧
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);

        }

        // 比较最后一行所有元素的路径和的最小值
        // triangleSize - 1, 是最后一行的下标
        int lastLineIndex = triangleSize - 1;
        int minTotal = f[lastLineIndex][0];
        for (int i = 1; i < triangleSize; i++) {
            minTotal = Math.min(minTotal, f[lastLineIndex][i]);
        }

        return minTotal;
    }

}
