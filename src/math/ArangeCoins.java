package math;

/**
 * @author leeray
 * @version 创建时间：2018年12月26日 下午4:48:18 <br>
 *          描述：441. 排列硬币<br>
 *          你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 
 *          给定一个数字 n，找出可形成完整阶梯行的总行数。
 * 
 *          n 是一个非负整数，并且在32位有符号整型的范围内。
 */
public class ArangeCoins {
	public int arrangeCoins(int n) {
		int start = 1, count = 0;
		while (n >= start) {
			count++;
			n -= start;
			start++;
		}
		return count;
	}
}
