package dynamicProgramming;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubarray {
	public int maxSubArray(int[] nums) {
		if(nums.length == 0 || nums == null) return 0;
		if(nums.length == 1) return nums[0];
		// 求和，然后判断和是否小于0，因为只要前面的和小于0，那么后面的数加上前面的和就一定比自身小，
		// 所以又重新求和，并和之前的最大子序和比较，取最大值。
		int ans = 0; //和
		int maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++){
			if(ans < 0){
				ans = 0;	//如果和都小于0了，那么还不如直接将当前值作为最大值
			}
			ans += nums[i];
			maxSum = Math.max(maxSum, ans);
		}
		return maxSum;
	}
	//-----------------------------------------//
	public int maxSubArray_2(int[] nums) {
        int sum = 0; //或者初始化为  sum = INT_MIN 也OK。
        int maxSum = nums[0];
        //动态规划
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
