package search;

import java.util.Arrays;

/**
 * @author leeray
 * @version 创建时间：2018年11月21日 下午7:16:56 <br>
 *          描述：153. 寻找旋转排序数组中的最小值<br>
 *          假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 *          ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 *          请找出其中最小的元素。
 * 
 *          你可以假设数组中不存在重复元素。
 */
public class SearchRotateArray {
	public int findMin(int[] nums) {
		Arrays.sort(nums);
		return nums[0];
	}

	public int findMin_2(int[] nums) {
		// 寻找断崖
		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				return nums[i] < res ? nums[i] : res;
			}
		}

		return res;
	}

}
