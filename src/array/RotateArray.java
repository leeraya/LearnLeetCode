package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月20日 下午4:08:19 <br>
 *          描述：189. 旋转数组<br>
 *          给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 *          示例 1:
 * 
 *          输入: [1,2,3,4,5,6,7] 和 k = 3 <br>
 *          输出: [5,6,7,1,2,3,4] <br>
 * 			解释: 向右旋转 1 步: [7,1,2,3,4,5,6] 向右旋转 2 步: [6,7,1,2,3,4,5] 向右旋转 3 步:
 *          [5,6,7,1,2,3,4]
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		int temp, previous;
		for (int i = 0; i < k; i++) {
			previous = nums[nums.length - 1];
			for (int j = 0; j < nums.length; j++) {
				// 交换previous与nums[j];
				temp = nums[j];
				nums[j] = previous;
				previous = temp;
			}
		}
	}
}
