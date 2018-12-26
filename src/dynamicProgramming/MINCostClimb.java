package dynamicProgramming;

/**
 * @author leeray
 * @version 创建时间：2018年12月26日 上午10:54:59 <br>
 *          描述：746. 使用最小花费爬楼梯<br>
 *          数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 
 *          每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 
 *          您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 */
public class MINCostClimb {
	public int minCostClimbingStairs(int[] cost) {
		if (cost == null || cost.length == 0)
			return 0;
		int len = cost.length;
		int dp[] = new int[len + 1];
		dp[0] = 0;// 跨0个台阶最小花费为0；
		dp[1] = 0;// 由于一次可以跨一个或两个台阶，所以跨一个台阶的最小花费是0；
		for (int i = 2; i <= len; i++) {
			// dp[i]表示跨到i阶梯的最小花费，它可以由前一个阶梯跳过来，也可以由前两个阶梯跳过来。
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
		}
		return dp[len];
	}
}
