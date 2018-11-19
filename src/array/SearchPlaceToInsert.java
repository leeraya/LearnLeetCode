package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月17日 下午3:18:00 <br>
 *          描述：35. 搜索插入位置<br>
 * 
 *          给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 *          你可以假设数组中无重复元素。
 */
public class SearchPlaceToInsert {
	public int searchInsert(int[] nums, int target) {
		int len = nums.length;
		//先考虑特殊情况1.没有找到，而且小于数组的最小值，2.没有找到，而且大于数组的最大值
		if(target < nums[0]) return 0;
		if(target > nums[len - 1]) return len;
		
		for(int i = 0; i < len; i++){
			if(target == nums[i]) return i;
		}
		
		for(int j = 0; j < len; j++){
			if(nums[j] < target && nums[j + 1] > target) return j + 1;
		}
		return 0;
	}
}
