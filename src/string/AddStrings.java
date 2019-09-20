package string;

/**
 * @author leeray
 * @version 1.0
 * @date 2019/9/19 0019 22:05
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddStrings {
    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "9999";
        String s = addStrings(s1, s2);
        System.out.println(s);
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        boolean flag = false;//有无进位

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int index1 = chars1.length - 1;
        int index2 = chars2.length - 1;
        while (index1 >= 0 || index2 >= 0) {
            int count = 0;
            if (index1 >= 0 && index2 >= 0) {
                if (flag) {
                    count += ((chars1[index1] - '0') + (chars2[index2] - '0') + 1);
                    //进位被使用，复原进位为false
                    flag = false;

                    if (count >= 10) {
                        res.append(count % 10);
                        flag = true;
                    } else {
                        res.append(count);
                    }
                } else {
                    //没有进位
                    count += ((chars1[index1] - '0') + (chars2[index2] - '0'));
                    if (count >= 10) {
                        res.append(count % 10);
                        flag = true;
                    } else {
                        res.append(count);
                    }
                }
                index1--;
                index2--;
            } else if (index1 >= 0 && index2 < 0) {
                if (flag) {
                    count += 1 + (chars1[index1] - '0');
                    flag = false;
                    if (count >= 10) {
                        res.append(count % 10);
                        flag = true;
                    } else {
                        res.append(count);
                    }
                } else {
                    count += chars1[index1] - '0';
                    if (count >= 10) {
                        res.append(count % 10);
                    } else {
                        res.append(count);
                    }
                }
                index1--;
            } else if (index1 < 0 && index2 >= 0) {
                if (flag) {
                    count += 1 + (chars2[index2] - '0');
                    flag = false;
                    if (count >= 10) {
                        res.append(count % 10);
                        flag = true;
                    } else {
                        res.append(count);
                    }
                } else {
                    count += chars2[index2] - '0';
                    if (count >= 10) {
                        res.append(count % 10);
                    } else {
                        res.append(count);
                    }
                }
                index2--;
            }
        }
        if (flag) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
