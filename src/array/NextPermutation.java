package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月27日 下午8:04:48 <br>
 *          描述：31. 下一个排列<br>
 *          实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 
 *          如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 *          必须原地修改，只允许使用额外常数空间。
 * 
 *          以下是一些例子，<br>
 * 			输入位于左侧列，其相应输出位于右侧列。 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		// 先从后往前找到第一个非逆序排列的
		int i = nums.length - 2;
		for (; i >= 0 && nums[i] >= nums[i + 1]; i--)
			;
		// 此时，i指向了第一个不满足逆序排列的数组元素，现在要做的就是再次从后往前，找到比该元素大的最小元素
		// 之后将它们交换。
		if (i >= 0) {
			int j = nums.length - 1;
			for (; j > i; j--) {
				if (nums[j] > nums[i]) {
					// 交换
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
					break;
				}
			}
		}
		// 接下来要将i之后的元素进行reverse操作
		int m = i + 1, n = nums.length - 1;
		while (m < n) {
			int temp = nums[m];
			nums[m] = nums[n];
			nums[n] = temp;
			m++;
			n--;
		}
	}
}
