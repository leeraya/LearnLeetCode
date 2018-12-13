package array;

/**
 * @author leeray
 * @version 创建时间：2018年12月13日 下午7:02:40 <br>
 *          描述：643. 子数组最大平均数 I<br>
 *          给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 */
public class MaxAverage {
	public double findMaxAverage(int[] nums, int k) {
		int max = 0;
		int sum = 0;
		// 求初始数组
		for (int i = 0; i < k; i++) {
			sum += nums[i];
			max = sum;
		}
		for (int i = k; i < nums.length; i++) {
			sum += nums[i] - nums[i - k];
			max = Math.max(sum, max);
		}
		return max * 1.0 / k;
	}
}
