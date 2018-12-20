package array;

/**
 * @author leeray
 * @version 创建时间：2018年12月20日 下午12:27:09 <br>
 *          描述：922. 按奇偶排序数组 II<br>
 *          给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 
 *          对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 
 *          你可以返回任何满足上述条件的数组作为答案。
 */
/*
 * -Dgenuitec.honorDevMode=true -Dosgi.dev=true 解决exit code = -1
 */
public class SortParityArray {
	public int[] sortArrayByParityII(int[] A) {
		if (A == null || A.length == 0)
			return A;
		int len = A.length;
		int temp1[] = new int[len];
		int temp2[] = new int[len];
		int index1 = 0, index2 = 0;
		for (int i = 0; i < len; i++) {
			if (A[i] % 2 == 0) {
				//temp1装偶数元素
				temp1[index1++] = A[i];
			} else {
				//temp2装奇数元素
				temp2[index2++] = A[i];
			}
		}
		//分别指向数组temp1,temp2的索引要重新归零。
		//其实不归零也行，只要在下面的循环中每次减小索引就行，相当于从后往前装入即:
		//--index1;--index2;注意要先减
		index1 = 0;
		index2 = 0;
		int res[] = new int[len];
		// 装入
		for (int i = 0; i < len; i++) {
			// 偶数索引，就从偶数数组中取数装入
			if (i % 2 == 0) {
				res[i] = temp1[index1++];
			} else {
				//如果碰到奇数索引，就从奇数数组中取数装入
				res[i] = temp2[index2++];
			}
		}
		return res;
	}
}
