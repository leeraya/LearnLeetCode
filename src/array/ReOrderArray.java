package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 1.0
 * @date 2019/9/22 0022 16:49
 * niuke
 * 调整数组顺序使奇数位于偶数前面
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i : array) {
            if (i % 2 == 0) {
                //偶数
                list2.add(i);
            } else {
                list1.add(i);
            }
        }
        int len = list1.size();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (i < len) {
                array[i] = list1.get(i);
            } else {
                array[i] = list2.get(i - len);
            }
        }
    }
}
