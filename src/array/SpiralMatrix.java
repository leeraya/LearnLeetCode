package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2018年11月17日 下午6:30:09 <br>
 *          描述：54. 螺旋矩阵<br>
 *          给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return list;
		
		int m = matrix.length, n = matrix[0].length;
		int top = 0, bottom = m - 1, left = 0, right = n - 1;
		while (list.size() < m * n) {
			for (int col = left; col <= right; col++) {
				list.add(matrix[top][col]);
			}
			top++;
			if (list.size() < m * n) {
				for (int row = top; row <= bottom; row++) {
					list.add(matrix[row][right]);
				}
				right--;
			}
			
			if (list.size() < m * n) {
				for(int col = right; col >= left; col--){
					list.add(matrix[bottom][col]);
				}
				bottom--;
			}
			
			if (list.size() < m * n) {
				for(int row = bottom; row >= top; row--){
					list.add(matrix[row][left]);
				}
				left++;
			}
		}
		return list;
	}
}
