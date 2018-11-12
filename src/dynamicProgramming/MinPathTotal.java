package dynamicProgramming;
/**
 * 
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

     说明：每次只能向下或者向右移动一步。
示例:
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 */
public class MinPathTotal {
	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
        int [][] minTotal = new int[m][n];
        minTotal[0][0] = grid[0][0];
        //初始化，注意数组越界
        for(int i = 1;i < m;i++){
        	minTotal[i][0] = minTotal[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < n;j++){
        	minTotal[0][j] = minTotal[0][j - 1] + grid[0][j];
        }
        //当i > 0 && j > 0 通过递推关系式：minTotal[i][j] = grid[i][j] + Math.min(minTotal[i - 1][j], minTotal[i][j - 1])来求最右下角的值
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
               minTotal[i][j] = grid[i][j] + Math.min(minTotal[i - 1][j], minTotal[i][j - 1]);
            }
        }
        return minTotal[m - 1][n - 1];
    }
}
