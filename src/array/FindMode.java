package array;

import java.util.Arrays;

/**
 * @author leeray
 * @version 创建时间：2018年11月19日 下午6:05:09 <br>
 *          描述：169. 求众数<br>
 *          给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 *          你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class FindMode {
	// 因为众数是出现次数大于n/2的数字，所以排序之后中间的那个数字一定是众数。即nums[n/2]为众数。时间复杂度即排序的时间复杂度。
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
	//hash,记录元素出现的次数，次数大于n / 2的就是众数。
}
