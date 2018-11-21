package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月21日 下午3:58:41 <br>
 *          描述：48. 旋转图像<br>
 *          给定一个 n × n 的二维矩阵表示一个图像。
 * 
 *          将图像顺时针旋转 90 度。
 */
public class RotateMatrix {
	public void rotate(int[][] matrix) {
		//对角线翻转
		for(int i = 0; i < matrix.length; i++){
			for(int j = i; j < matrix[0].length; j++){	//注意这里的 j = i是为了避免同样的数对翻转两次，等于没有翻转
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		//水平翻转
		for(int i = 0; i < matrix.length; i++){
			for(int j =  0; j < matrix.length / 2; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - 1 - j];
				matrix[i][matrix.length - 1 - j] = temp;
			}
		}
	}
}
