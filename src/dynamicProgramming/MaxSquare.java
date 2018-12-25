package dynamicProgramming;

/**
 * @author leeray
 * @version 创建时间：2018年12月25日 下午6:22:27 <br>
 *          描述：221. 最大正方形<br>
 *          在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return 0;
        int m = matrix.length , n = matrix[0].length;
        int [][] dp = new int[m+1][n+1];
        int maxL = 0;
        for(int i = 1; i <= m; i++){
        	for(int j = 1; j <= n; j++){
        		if(matrix[i - 1][j - 1] == '1'){
        			dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
        		}
        		maxL = Math.max(maxL, dp[i][j]);
        	}
        }
        return maxL * maxL;
    }
}
