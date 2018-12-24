package dynamicProgramming;

/**
 * @author leeray
 * @version 创建时间：2018年12月24日 下午4:51:16 <br>
 *          描述：House Robber II<br>
 */
/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，<br>
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时， 相邻的房屋装有相互连通的防盗系统，<br>
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。<br>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */

/**
 * 这题和打家劫舍1的问题类似，唯一不同的是房屋现在是环形的。 假设房屋数量为n,
 * 由于相邻的房屋不能盗窃,当你盗窃第n间房屋是，还要保证第一间房屋没有被盗窃过<br>
 * 所以可以将环形变成直线，即分成1 ~ n-1 和2 ~ n<br>
 * 取两次直线的最大盗取钱财<br>
 *
 */
public class HouseRobber_2 {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		int len = nums.length;
		int max1 = 0 , max2 = 0;
		int [] temp1 = new int[len - 1];
		int [] temp2 = new int[len - 1];
		for(int i = 0; i < len - 1; i++){
			temp1[i] = nums[i];
		}
		for(int i = 1 , j = 0; i < len; i++ , j++){
			temp2[j] = nums[i];
		}
		max1 = Simple_Rob(temp1);
		max2 = Simple_Rob(temp2);
		return Math.max(max1, max2);
	}
	
	//
	public int Simple_Rob(int[] nums) {
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
