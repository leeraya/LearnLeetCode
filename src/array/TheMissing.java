package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月20日 上午9:06:46 <br>
 *          描述：268. 缺失数字<br>
 *          给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class TheMissing {
	/*
	 * 视为等差数列，求和，然后遍历数组，依次删除元素，最后所得值就是缺失的那个数
	 */
	public int missingNumber(int[] nums) {
		int n = nums.length + 1;
		int sum = n * (n - 1) / 2;
		for (int i = 0; i < nums.length; i++) {
			sum -= nums[i];
		}
		return sum;
	}

	/*
	 * 备忘录法
	 */
	public int missingNumber_2(int[] nums) {
		int[] arrs = new int[nums.length + 1];
		for (int i = 0; i < nums.length; ++i) {
			arrs[nums[i]] = 1;
		}
		for (int i = 0; i < arrs.length; ++i) {
			if (arrs[i] == 0) {
				return i;
			}
		}
		return 0;
	}
}
