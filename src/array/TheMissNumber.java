package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月17日 下午3:42:06 <br>
 *          描述：41. 缺失的第一个正数<br>
 *          找到一个未排序序列中的第一个缺失的正数。简而言之，就是看1在不在这个序列中，如果不在的话输出1；<br>
 *          否则看2在不在这个序列中，如果不在的话输出2；否则看3在不在这个序列中……
 *          你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
/*
 * 将数值大于0且小于数组长度的数值nums[i]，放入 i-1 的位置， 最后遍历数组，若nums[i] != i+1，则return i + 1; 注意:
 * 为了避免两次交换值相同，造成同一位置无限循环，所以加入nums[nums[i] - 1] !=
 * nums[i]。既考虑同一位置，也考虑不同位置同一数值的避免交换。
 */
public class TheMissNumber {
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		int i = 0;
		while (i < len) {
			if (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			} else {
				i++;
			}
		}
		for (int j = 0; j < len; j++) {
			if (nums[j] != j + 1) {
				return j + 1;
			}
		}
		return len + 1;
	}
}
