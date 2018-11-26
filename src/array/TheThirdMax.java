package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月26日 下午5:52:38 <br>
 *          描述：414. 第三大的数<br>
 *          给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 
 *          示例 1:
 * 
 *          输入: [3, 2, 1]
 * 
 *          输出: 1
 * 
 *          解释: 第三大的数是 1. <br>
 *          示例 2:
 * 
 *          输入: [1, 2]
 * 
 *          输出: 2
 * 
 *          解释: 第三大的数不存在, 所以返回最大的数 2 . <br>
 *          示例 3:
 * 
 *          输入: [2, 2, 3, 1]
 * 
 *          输出: 1
 * 
 *          解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。 存在两个值为2的数，它们都排第二。
 */
public class TheThirdMax {
	public int thirdMax(int[] nums) {
		int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
		// 通过三个循环，分别找到第一大和第二大以及第三大的数字
		boolean flag = false;
		// 找到max
		for (int i : nums) {
			if (i > max) {
				max = i;
			}
		}
		// 找到second
		for (int j : nums) {
			if (j >= second && j < max) {
				second = j;
			}
		}
		// 找到third
		for (int k : nums) {
			if (k >= third && k < second) {
				third = k;
				flag = true;
			}
		}
		if (flag) {
			return third;
		}
		return max;
	}
}
