import java.util.*;

/**
 * @author liuchuan
 * @date 2022/4/25 10:43 下午
 */
public class Test {

    @org.junit.Test
    public void test() {
        String s = "abcb";
        lengthOfLongestSubstring3(s);
    }

    public int lengthOfLongestSubstring3(String s) {
        // 第二次提交，参考执行范例，成功（用时+内存：100%，23%）
        int ans = 0, start = 0, len = s.length();
        int[] arr = new int[128];
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i);
            start = Math.max(start, arr[x]);
            ans = Math.max(ans, i - start + 1);
            arr[x] = i + 1;
        }

        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> substring = new HashMap<>();
        int maxLen = 0, left = 0;
        for (int right = 0; right < n; right++) {
            char aChar = s.charAt(right);

            if (substring.containsKey(aChar)) {
                left = Math.max(left, substring.get(aChar) + 1);
            }

            substring.put(aChar, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> substring = new HashSet<>();
        int n = s.length();

        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            // 从第二个字符开始, 把前面的窗口都删掉
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                substring.remove(s.charAt(i - 1));
            }

            // rk不变, 继续判断新的起始位置的值是否已经存在
            while (rk + 1 < n && !substring.contains(s.charAt(rk + 1))) {
                // 只要一包含, 那么右指针就停止移动
                substring.add(s.charAt(rk + 1));

                // 不断地移动右指针
                ++rk;
            }

            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
