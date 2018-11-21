package search;

/**
 * @author leeray
 * @version 创建时间：2018年11月21日 下午6:51:34 <br>
 *          描述：34. 在排序数组中查找元素的第一个和最后一个位置<br>
 *          给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 *          你的算法时间复杂度必须是 O(log n) 级别。
 * 
 *          如果数组中不存在目标值，返回 [-1, -1]。
 * 
 *          示例 1:
 * 
 *          输入: nums = [5,7,7,8,8,10], target = 8 输出: [3,4]
 *          <p>
 *          示例 2:
 * 
 *          输入: nums = [5,7,7,8,8,10], target = 6 输出: [-1,-1]
 *          </p>
 */
public class FirstAndLast {
	public int[] searchRange(int[] nums, int target) {

		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;

		if (nums == null || nums.length == 0)
			return res;

		int left = 0, right = nums.length - 1;
		boolean flag1 = false, flag2 = false;

		while (left <= right) {
			//保存左边第一个出现的target
			if (nums[left] == target && flag1 == false) {
				res[0] = left;
				flag1 = true;
			}
			//保存右边第一个出现的target
			if (nums[right] == target && flag2 == false) {
				res[1] = right;
				flag2 = true;
			}
			// 如果a[0] 和a[1]都已经找到，则退出
			if (flag1 && flag2)
				break;

			int mid = left + (right - left) / 2;
			if (nums[mid] > target) {
				right = --mid;
			} else if (nums[mid] < target) {
				left = ++mid;
			} else {
				if (!flag1) {
					++left;
				}
				if (!flag2) {
					--right;
				}
			}
		}
		return res;
	}
}
