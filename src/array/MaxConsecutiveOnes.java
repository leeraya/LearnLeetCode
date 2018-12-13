package array;

/**
 * @author leeray
 * @version 创建时间：2018年12月13日 下午6:34:45 <br>
 *          描述：485. 最大连续1的个数<br>
 *          给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class MaxConsecutiveOnes {
	// --------------------------------//
	// 我的解法，很low.耗时巨长。
	public int findMaxConsecutiveOnes(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1) {
			if (nums[0] == 1)
				return 1;
			if (nums[0] == 0)
				return 0;
		}
		int maxl = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				int count = 0; // 保存每次的长度
				for (int j = i; j < nums.length; j++) {
					if (nums[j] == 1 && j != nums.length - 1) {
						count++;
					} else if (nums[j] == 1 && j == nums.length - 1) {
						count++;
						maxl = Math.max(maxl, count);
						break;
					} else {
						maxl = Math.max(maxl, count);
						i = j;
						break;
					}
				}
			}
		}
		return maxl;
	}

	// -----------------------------------//
	public int findMaxConsecutiveOnes_2(int[] nums) {
		int i = 0;
		int j = 0;
		int result = 0;
		for (int k = 0; k < nums.length; k++) {
			if (nums[k] == 1) {
				i++;
			}

			if (nums[k] == 0) {
				j = k;
			}

			if (j != 0) {
				if (i > result) {
					result = i;
				}
				i = 0;
				j = 0;
			}
		}
		// 防止最后一位数不是0，造成漏解的情况
		if (i > result) {
			return i;
		}
		return result;
	}
}
