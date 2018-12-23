package math;

/**
 * @author leeray
 * @version 创建时间：2018年12月23日 下午6:22:01 <br>
 *          描述：136. 只出现一次的数字<br>
 *          给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */

/*
 * 位运算，全部异或就是只出现一次的数了
 */
public class SingleNumber {
	public static int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}
		return result;
	}
}
