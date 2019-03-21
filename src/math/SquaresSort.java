package math;

import java.util.Arrays;

/**
 * @author leeray
 * @version 创建时间：2019年3月21日 下午6:13:45 <br>
 *          描述：977. 有序数组的平方<br>
 *          给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 
 * 
 */
public class SquaresSort {
	public int[] sortedSquares(int[] A) {
		int len = A.length;
		int ret[] = new int[len];
		for (int i = 0; i < len; i++) {
			ret[i] = A[i] * A[i];
		}
		Arrays.sort(ret);
		return ret;
	}
}
