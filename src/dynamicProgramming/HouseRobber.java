package dynamicProgramming;

/**
 * @author leeray
 * @version 创建时间：2018年12月24日 下午4:25:54 <br>
 *          描述：198. 打家劫舍<br>
 */
/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金， <br>
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统， 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */

/**
 * 这是一个动态规划问题 <br>
 * 原问题是求n个房间里能偷盗的最多的钱数，但是要求相邻的房屋不能盗窃，因为装了防盗装置。<br>
 * 就是说：你如果要偷第i家，那么第i-1家就不能偷。<br>
 * 
 * 子问题：偷盗前1家的最大金额是nums[0],偷盗前2家的最大金额是max(nums[0],nums[1]),因为不能被防盗装置发现。<br>
 * 那么偷盗第i家的最大金额就是nums[i] + 偷前i - 2家的最大金额，或者是前i-1家的最大金额。取二者中的最大值。
 * 用dp[i]来表示前i家可以偷到的最大金额，dp[0] = nums[0],dp[1] = max(nums[0],nums[1]);
 * 可以得到递推式：当i > 3时，dp[i] = max(nums[i] + dp[i - 2] , dp[i - 1])
 * 
 */
public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int len = nums.length;
		if(len == 1){
			return nums[0];
		}
		if(len == 2){
			return Math.max(nums[0], nums[1]);
		}
		int [] dp = new int[len];
		//初始化
		dp[0] = nums[0];dp[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < nums.length; i++){
			dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
		}
		return dp[len - 1];
	}
}
