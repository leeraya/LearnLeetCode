package array;

/**
 * @author leeray
 * @version 创建时间：2019年3月23日 下午4:46:49 <br>
 *          描述：941. 有效的山脉数组<br>
 *          给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 
 *          让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * 
 *          A.length >= 3 在 0 < i < A.length - 1 条件下，存在 i 使得：<br>
 *         A[0] < A[1] < ... A[i-1] < A[i] A[i] > A[i+1] > ... > A[B.length -1]<br>
 */
public class ValidMount {
	/**
	 * 基本思路就是找山顶的位置是不是一致的，而且要考虑完全顺序和完全逆序的情况 index1,index2都不能在边上。
	 */
	public boolean validMountainArray(int[] A) {

		if (A.length <= 2)
			return false;

		int index1 = 0, index2 = A.length - 1;
		// 从左到右找第一个山峰index1
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] < A[i + 1]) {
				index1 = i + 1;
			} else {
				break;
			}
		}
		// 从右到左找第一个山峰index2
		for (int i = A.length - 1; i >= 1; i--) {
			if (A[i] < A[i - 1]) {
				index2 = i - 1;
			} else {
				break;
			}
		}
		// 防止完全顺序和完全逆序
		return index1 == index2 && index1 != 0 && index2 != A.length - 1;
	}
}
