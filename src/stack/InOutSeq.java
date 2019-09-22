package stack;

import java.util.Stack;

/**
 * @author leeray
 * @version 1.0
 * @date 2019/9/22 0022 17:06
 * niuke
 * 栈的压入、弹出序列
 * <p>
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class InOutSeq {
    public static void main(String[] args) {
        int arr1[] = {1};
        int arr2[] = {2};
        boolean b = IsPopOrder(arr1, arr2);
        System.out.println(b);
    }

    /**
     * 一边入栈一边出栈
     * 建立一个辅助栈用于模拟栈中元素的压入与弹出
     * Stack
     * 12345->45321
     * <p>
     * 1入栈，1 != 4
     * 2入栈, 2 != 4
     * 3入栈，3 != 4
     * 4入栈，4 == 4，4弹出。
     * 5入栈，5 == 5，5弹出。
     * 最后判断Stack是否为空。
     * 不为空接着弹出与序列比较
     *
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int inIndex = 0, outIndex = 0;
        int len = pushA.length;
        while (!stack.empty() || inIndex < len || outIndex < len) {
            if (inIndex < len) {
                stack.push(pushA[inIndex]);
                if (stack.peek() == popA[outIndex]) {
                    stack.pop();
                    outIndex++;
                }
                inIndex++;
            } else {
                if (stack.peek() == popA[outIndex]) {
                    stack.pop();
                    outIndex++;
                } else {
                    break;
                }
            }
        }
        return stack.size() == 0;
    }
}
