package array;

import java.util.Arrays;

/**
 * @author leeray
 * @version 创建时间：2018年11月19日 上午9:42:13 <br>
 *          描述：75. 颜色分类<br>
 * 
 *          给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 
 *          此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 
 *          注意: 不能使用代码库中的排序函数来解决这道题。
 */
public class ColorSorter {
	public void sortColors(int[] nums) {
		Arrays.sort(nums);
	}

	// 冒泡排序
	public void sortColors_2(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}
}
