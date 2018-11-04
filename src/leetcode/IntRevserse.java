package leetcode;

import org.junit.Test;

/*
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。

	       示例 1:
		输入: 123
		输出: 321
		
	       示例 2:
		输入: -123
		输出: -321
		
	       示例 3:
		输入: 120
		输出: 21
注意:
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class IntRevserse {
	public int reverse(int n) {
		int res = 0;
		while (n != 0) {
			long tmp = (long) res * 10;	//之后的操作要*10，所以要提前判断一下
			if (tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE) {
				return 0;
			}
			res = res * 10 + n % 10;		//反转
			n /= 10;
		}
		return res;
	}

	@Test
	public void test1() {
		int sum = -2147483648;
		sum = reverse(sum);
		System.out.println(sum);
	}
}
