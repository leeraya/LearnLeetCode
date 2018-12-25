package dynamicProgramming;

/**
 * @author leeray
 * @version 创建时间：2018年12月25日 下午6:57:18 <br>
 *          描述：300. 最长上升子序列<br>
 *          给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 
 */
public class LongestIncreasingSquence {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int dp[] = new int[len];
		int res = 1;
		dp[0] = 1;
		for (int i = 1; i < len; i++) {
			dp[i] = 1;
			int maxDP = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i])
					maxDP = Math.max(maxDP, dp[j]);
			}
			dp[i] = maxDP + 1;
			res = Math.max(dp[i], res);
		}
		return res;
	}
}
