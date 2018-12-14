package dynamicProgramming;

/**
 * @author leeray
 * @version 创建时间：2018年12月14日 下午3:50:04 <br>
 *          描述：209. 长度最小的子数组<br>
 *          给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s
 *          的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 */
public class MINLengthSub {
	public int minSubArrayLen(int s, int[] nums) {
		// 滑动窗口
		int minV = Integer.MAX_VALUE;
		int sum = 0;
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				minV = Math.min(minV, i - left + 1);
				sum -= nums[left++];
			}
		}
		return (minV != Integer.MAX_VALUE) ? minV : 0;
	}
}
