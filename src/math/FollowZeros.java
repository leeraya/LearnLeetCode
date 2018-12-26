package math;

/**
 * @author leeray
 * @version 创建时间：2018年12月26日 下午3:32:35 <br>
 *          描述：172. 阶乘后的零<br>
 *          给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
public class FollowZeros {
	public int trailingZeroes(int n) {
		// 尾随0通常由因子5 和 2组成，直接统计组成n的因子中五的个数即可
		int count = 0;
		while (n > 0) {
			count += n / 5;
			n /= 5;
		}
		return count;
	}
}
