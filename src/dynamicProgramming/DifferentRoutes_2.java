package dynamicProgramming;

/**
 * @author leeray
 * @version 创建时间：2018年12月25日 上午11:28:32 <br>
 * 			描述：63. 不同路径 II<br>
 * 			一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 *          机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 *          现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 */
/**
 * 
 * 示例 1:
 * 
 * 输入: [ [0,0,0], [0,1,0], [0,0,0] ] 输出: 2 <br>
 * 解释: 3x3 网格的正中间有一个障碍物。<br>
 * 从左上角到右下角一共有 2 条不同的路径：<br>
 * 1. 向右 -> 向右 -> 向下 -> 向下<br>
 * 2. 向下 -> 向下 -> 向右 -> 向右<br>
 *
 */

/**
 * 基本的递推式还是dp[i][j] = dp[i - 1][j]+dp[i][j - 1]<br>
 * 但是要考虑障碍物，这里有两种情况<br>
 * 一种是障碍物在边界上，这时候障碍物之后的地点都不可达<br>
 * 一种是障碍物在内部，只需要判断是否为1就可以了，如果为1，则dp为0，如果不是就用递推式计算。<br>
 */
public class DifferentRoutes_2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null)
			return 0;
		//取grid长宽
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if(m == 0 || n == 0){
			return 0;
		}
		//如果入口都有障碍，那么直接返回0。
		if(obstacleGrid[0][0] == 1){
			return 0;
		}
		int [][] dp = new int[m][n];
		dp[0][0] = 1;
		//对边界进行初始化，要注意对障碍物情况的解决
		//左边界
		for(int i = 1; i < m; i++){
			//如果该点不等于1并且前一步不等于1,那么这个点可以到达
			if(obstacleGrid[i][0] != 1 && dp[i - 1][0] != 0){
				dp[i][0] = 1;
			}
		}
		//上边界
		for(int i = 1; i < n; i++){
			if(obstacleGrid[0][i] != 1 && dp[0][i - 1] != 0){
				dp[0][i] = 1;
			}
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				//处理内部障碍
				if(obstacleGrid[i][j] != 1){
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m-1][n-1];
	}
}
