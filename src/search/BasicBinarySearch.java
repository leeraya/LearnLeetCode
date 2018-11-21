package search;

/**
 * @author leeray
 * @version 创建时间：2018年11月21日 下午4:46:36 <br>
 *          描述：704. 二分查找<br>
 *          给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的
 *          target，如果目标值存在返回下标，否则返回 -1。
 */
public class BasicBinarySearch {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return mid;
			if (target < nums[mid]) {
				// target在左半区
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
