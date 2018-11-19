package array;

import java.util.Arrays;

/**
 * @author leeray
 * @version 创建时间：2018年11月19日 下午7:18:19 <br>
 *          描述：561. 数组拆分 I<br>
 *          给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn)
 *          ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * 
 *          示例 1:
 * 
 *          输入: [1,4,3,2]
 * 
 *          输出: 4 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 */
/*
 * 使每一对数尽可能地靠近，使用排序可以实现
 */
public class BreakArray {
	public int arrayPairSum(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);

		int len = nums.length;
		int sum = 0;
		for (int i = 0; i < len; i += 2) {
			sum += nums[i];
		}
		return sum;
	}
}
