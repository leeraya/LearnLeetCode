package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月20日 上午10:39:52 <br>
 *          描述：287. 寻找重复数<br>
 *          给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和
 *          n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。 <br>
 *          不能更改原数组（假设数组是只读的）。 <br>
 *          只能使用额外的 O(1) 的空间。 时间复杂度小于 O(n2) 。<br>
 *          数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class FindDuplicate {
	public int findDuplicate(int[] nums) {
		// 二分查找，算法复杂度：nlogn
		int high = nums.length - 1, low = 0;
		while(low < high){
			int mid = (high + low)/2;
			int count = 0;
			for(int i = 0; i < nums.length; i++){
				if(nums[i] <= mid) count++;
			}
			if(count > mid){
				//说明小于mid的占多数，重复的元素在左边
				high = mid;
			}else{
				low = mid + 1;
			}
		}
		return low;
	}
}
