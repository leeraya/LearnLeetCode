package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leeray
 * @version 创建时间：2018年12月18日 下午5:54:57 <br>
 *          描述：350. 两个数组的交集 II<br>
 *          给定两个数组，编写一个函数来计算它们的交集。
 * 
 *          示例 1:
 * 
 *          输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2,2] <br>
 * 			示例 2:
 * 
 *          输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [4,9]
 */
public class Intersection_2 {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) {
			return nums1;
		}
		if (nums2 == null || nums2.length == 0) {
			return nums2;
		}
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			} else {
				map.put(nums1[i], 1);
			}
		}

		for (int j = 0; j < nums2.length; j++) {
			if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
				list.add(nums2[j]);
				map.put(nums2[j], map.get(nums2[j]) - 1);
			}
		}

		int[] res = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			res[k] = list.get(k);
		}
		return res;
	}
}
