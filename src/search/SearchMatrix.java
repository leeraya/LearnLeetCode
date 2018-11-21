package search;

/**
 * @author leeray
 * @version 创建时间：2018年11月21日 下午4:35:53 <br>
 *          描述：74. 搜索二维矩阵<br>
 *          编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 *          每行中的整数从左到右按升序排列。 每行的第一个整数大于前一行的最后一个整数。 示例 1:
 * 
 *          输入: matrix = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ]
 *          target = 3 输出: true
 */
public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null)
			return false;

		if (matrix.length == 0 || matrix[0].length == 0)
			return false;

		int rows = matrix.length, cols = matrix[0].length - 1;

		int row = 0, col = cols;
		while (row < rows && col >= 0) {
			if (target < matrix[row][col]) { // target就在这一行，持续减小行数，就可以在这一行找到target
				col--;
			} else if (target > matrix[row][col]) { // 搜索下一行
				row++;
			} else {
				return true;
			}
		}
		return false;
	}
}
