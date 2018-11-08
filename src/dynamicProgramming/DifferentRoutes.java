package dynamicProgramming;

/**
 * 62. 不同路径: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 问总共有多少条不同的路径？
 */
/*
 * 动态规划法
 * 在m x n的表格中，从起点dp[0][0] 到dp[m][n] 的路线其实等于起点到dp[m][n - 1]+dp[m - 1][n]的路线总和
 */
public class DifferentRoutes {
	public int uniquePaths(int m, int n) {
		int [][] dp = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(i == 0 || j == 0) {
					dp[i][j] = 1;	//初始化数组
				}else{
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}
		}
		return dp[m-1][n-1];
	}
}
