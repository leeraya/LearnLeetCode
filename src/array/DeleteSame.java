package array;

/**
 * 
 * 26. 删除排序数组中的重复项<br>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
/*
 * 思路就是指找不重复的元素，最后返回point+1所指的位置就是不重复元素的长度
 */
public class DeleteSame {
	public int removeDuplicates(int[] nums) {
		int len = nums.length;
		int point = 0;
		for(int i = 0; i < len; i++){
			if(nums[point] != nums[i]){
				point++;
				nums[point] = nums[i];
			}
		}
		point++;
		return point;
	}
}
