package dynamicProgramming;

/**
 * @author leeray
 * @version 创建时间：2018年12月25日 下午4:32:50 <br>
 *          描述：152. 乘积最大子序列<br>
 *          给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 */
public class MaxPlusSubArray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int ans = nums[0];
		// 由于要考虑负数的情况，要同时记录当前情况下的最大值和最小值
		// 正数相乘为正数，负数相乘也是正数。
		int maxm = nums[0], minm = nums[0];
		for (int i = 1; i < len; i++) {
			// 设置临时变量是想要下面求maxm 和 minm时，比较的数值还是循环前的值
			// 如果不设置临时变量，那么会发生这样的情况：
			// 一次循环中，求得了当前的maxm值，接下来求minm, minm的值却决于循环前的maxm,这样会造成错误。
			int max_temp = maxm;
			int min_temp = minm;
			maxm = Math.max(nums[i], Math.max(nums[i] * max_temp, nums[i] * min_temp));
			minm = Math.min(nums[i], Math.min(nums[i] * max_temp, nums[i] * min_temp));
			ans = Math.max(ans, maxm);
		}
		return ans;
	}
}
