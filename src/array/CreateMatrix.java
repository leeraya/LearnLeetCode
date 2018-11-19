package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月19日 下午4:04:23 <br>
 *          描述：59. 螺旋矩阵 II<br>
 *          给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 *          示例:
 * 
 *          输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class CreateMatrix {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int top = 0, bottom = n - 1, left = 0, right = n - 1;
		int count = 0, num = 1;
		while (count < n * n) {
			for (int i = left; i <= right; i++) {
				matrix[top][i] = num++;
				count++;
			}
			top++;
			if (count < n * n) {
				for (int j = top; j <= bottom; j++) {
					matrix[j][right] = num++;
					count++;
				}
				right--;
			}

			if (count < n * n) {
				for (int p = right; p >= left; p--) {
					matrix[bottom][p] = num++;
					count++;
				}
				bottom--;
			}

			if (count < n * n) {
				for (int q = bottom; q >= top; q--) {
					matrix[q][left] = num++;
					count++;
				}
				left++;
			}
		}
		return matrix;
	}
}
