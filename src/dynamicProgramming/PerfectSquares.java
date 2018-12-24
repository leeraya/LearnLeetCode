package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2018年12月24日 下午7:05:23 <br>
 *          描述：<br>
 *          给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于
 *          n。你需要让组成和的完全平方数的个数最少。
 */
public class PerfectSquares {
	public int numSquares(int n) {
		if(n <= 0)
			return 0;
		int dp[] = new int[n+1];
        
		//找到小于等于n的所有完全平方数，存于list中
		List<Integer> squaresList = new ArrayList<Integer>();
		for(int i = 1; i * i <= n; i++){
			if(i * i <= n)
				squaresList.add(i * i);
		}
        
		for(int i = 1;i <= n; i++){
            dp[i] = i;
			for(int num : squaresList){
				if(num > i)
					break;
				//1 + dp[i - num] 表示将组成i的完全平方数分为num 与 组成i - num的最小完全平方数的数量
				dp[i] = Math.min(dp[i], 1 + dp[i - num]);
			}
		}
		return dp[n];
	}
}
