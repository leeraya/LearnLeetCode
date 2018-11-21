package search;

/**
 * @author leeray
 * @version 创建时间：2018年11月21日 上午10:59:36 <br>
 *          描述：33. 搜索旋转排序数组<br>
 *          假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 *          ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 *          搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 *          你可以假设数组中不存在重复的元素。
 * 
 *          你的算法时间复杂度必须是 O(log n) 级别。
 */
public class BinarySearch {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int st = 0, ed = nums.length - 1;
		while (st <= ed) {
			int mid = st + (ed - st) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] >= nums[st]) {
				if (nums[mid] > target && target >= nums[st]) {
					ed = mid - 1;
				} else {
					st = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[ed]) {
					st = mid + 1;
				} else {
					ed = mid - 1;
				}
			}
		}
		return -1;
	}
}
