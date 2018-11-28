package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leeray
 * @version 创建时间：2018年11月28日 上午10:03:05 <br>
 *          描述：532. 数组中的K-diff数对<br>
 *          <p>
 *          给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i,
 *          j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 *          </p>
 */
public class K_Diff {
	public int findPairs(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + k == nums[j]) {
					map.put(nums[i], nums[j]); // map的特点是不会有重复的key,在这里可以避免重复
				} else if (nums[j] - nums[i] > k) {
					// 如果此时nums[j]就已经超过了k范围，那么内循环后面的就不用再看了，它一定不满足。
					break;
				}
			}
		}
		return map.size();
	}
}
