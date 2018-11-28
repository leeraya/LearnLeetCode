package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leeray
 * @version 创建时间：2018年11月28日 上午11:24:39 <br>
 *          描述：349. 两个数组的交集<br>
 *          给定两个数组，编写一个函数来计算它们的交集。
 * 
 *          示例 1:
 * 
 *          输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2] <br>
 *          示例 2:
 * 
 *          输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [9,4] 说明:
 * 
 *          输出结果中的每个元素一定是唯一的。 我们可以不考虑输出结果的顺序。
 */
public class Intersection {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) {
			return nums1;
		}
		if (nums2 == null || nums2.length == 0) {
			return nums2;
		}
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], 1);
		}

		for (int j = 0; j < nums2.length; j++) {
			if (map.containsKey(nums2[j]) && !list.contains(nums2[j])) {
				list.add(nums2[j]);
			}
		}

		int[] res = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			res[k] = list.get(k);
		}
		return res;
	}
}
