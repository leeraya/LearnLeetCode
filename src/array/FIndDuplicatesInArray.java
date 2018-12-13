package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2018年12月13日 下午4:45:58 <br>
 *          描述：442. 数组中重复的数据<br>
 *          给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 
 *          找到所有出现两次的元素。
 * 
 *          你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 */
public class FIndDuplicatesInArray {
	public List<Integer> findDuplicates(int[] nums) {

		List<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			//第二次访问到该元素时，就将其加入返回的数组中
			if (nums[Math.abs(nums[i]) - 1] < 0) {
				res.add(Math.abs(nums[i]));
			}
			// 每访问一个元素，就将其置为其相反数
			nums[Math.abs(nums[i]) - 1] *= (-1);
		}
		return res;
	}
}
