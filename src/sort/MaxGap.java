package sort;

/**
 * @author leeray
 * @version 创建时间：2018年12月19日 上午11:12:20 <br>
 *          描述：164. 最大间距<br>
 *          给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 
 *          如果数组元素个数小于 2，则返回 0。
 * 
 *          示例 1:
 * 
 *          输入: [3,6,9,1] 输出: 3 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9)
 *          之间都存在最大差值 3。
 */
public class MaxGap {
	public int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;
		int len = nums.length;
		int maxn = Integer.MIN_VALUE, minn = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			maxn = Math.max(maxn, nums[i]);
			minn = Math.min(minn, nums[i]);
		}
		if (maxn == minn)
			return 0;
		// 准备桶子
		boolean hasNum[] = new boolean[len + 1];
		int[] mins = new int[len + 1];
		int[] maxs = new int[len + 1];
		// 将num放入桶子中去
		for (int i = 0; i < len; i++) {
			int bid = mapToBucket(nums[i], len, maxn, minn);
			mins[bid] = hasNum[bid] ? Math.min(nums[i], mins[bid]) : nums[i];
			maxs[bid] = hasNum[bid] ? Math.max(nums[i], maxs[bid]) : nums[i];
			hasNum[bid] = true;
		}
		int res = 0, preMax = maxs[0];
		// 取间距
		for (int i = 1; i <= len; i++) {
			if (hasNum[i]) {
				res = Math.max(res, mins[i] - preMax);
				preMax = maxs[i];
			}
		}
		return res;
	}

	// 将num映射到对应的桶子里的函数
	private int mapToBucket(long num, long len, long max, long min) {
		return (int) ((num - min) * len / (max - min));
	}
}
