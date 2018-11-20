package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月20日 上午9:54:10 <br>
 *          描述：283. 移动零<br>
 *          给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 *          示例:
 * 
 *          输入: [0,1,0,3,12] 输出: [1,3,12,0,0] 说明:
 * 
 *          必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
 */
public class MoveZero {
	public void moveZeroes(int[] nums) {
		// 尝试冒泡排序
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				//其实这就是冒泡排序，冒泡排序的特点是每一趟排序都会使最大的元素沉底，在这个具体的题目里
				//就是0沉底了，具体判断就是只要当前的数字是0，就要与其后的元素进行交换。
				if (nums[j] == 0) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
	}
}
