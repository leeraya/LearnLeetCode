package math;

/**
 * @author leeray
 * @version 1.0
 * @date 2019/9/19 0019 21:25
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 */
public class AddDigits {
    public static int addDigits(int num) {
        String s = String.valueOf(num);
        if (s.length() == 1) {
            return num;
        } else {
            while (s.length() > 1) {
                int count = 0;
                for (char c : s.toCharArray()) {
                    count += c - '0';
                }
                s = String.valueOf(count);
            }
        }
        return Integer.valueOf(s);
    }

    public static void main(String[] args) {
        String s = String.valueOf(11);
        System.out.println(s);
        int i = addDigits(38);
        System.out.println(i);
    }
}
