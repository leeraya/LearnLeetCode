package dynamicProgramming;

import java.util.Arrays;

/**
 * @author leeray
 * @version 创建时间：2018年12月14日 下午6:04:07 <br>
 *          描述：322. 零钱兑换<br>
 *          给定不同面额的硬币 coins 和一个总金额
 *          amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class ChangeCoins {
	public int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		int len = coins.length;
		int[] ans = new int[amount + 1];
		Arrays.fill(ans, Integer.MAX_VALUE - 1);
		ans[0] = 0;
		for (int i = 0; i <= amount; i++) {
			for (int j = 0; j < len; j++) {
				if (coins[j] <= i) {
					ans[i] = Math.min(ans[i], ans[i - coins[j]] + 1);
				}
			}
		}
		return (ans[amount] == Integer.MAX_VALUE - 1) ? -1 : ans[amount];
	}
}
