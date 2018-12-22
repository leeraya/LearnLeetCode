package sort;

import java.util.Arrays;

/**
 * @author leeray
 * @version 创建时间：2018年12月22日 下午3:33:36 <br>
 * 			描述：<br>
 */
public class WiggleSort {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int[] temp = nums.clone();
		for (int i = (temp.length - 1) / 2, j = 0; i >= 0; i--, j += 2)
			nums[j] = temp[i];
		for (int i = temp.length - 1, j = 1; i > (temp.length - 1) / 2; i--, j += 2)
			nums[j] = temp[i];
	}
}
