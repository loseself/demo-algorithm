package interview;

/**
 * @author liuchuan
 * @date 2022/5/17 2:43 下午
 */
public class StringTest {

    public static void main(String[] args) {
        String ab = "ab";

        String a = "a";
        String b = "b";

        String s1 = "a" + "b";
        String s2 = a + b;
        System.out.println(ab == s1);
        System.out.println(ab == s2);
    }

}
