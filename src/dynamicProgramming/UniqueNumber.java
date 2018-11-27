package dynamicProgramming;

/**
 * @author leeray
 * @version 创建时间：2018年11月27日 下午3:14:56 <br>
 *          描述：357. 计算各个位数不同的数字个数<br>
 *          给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * 
 *          示例:
 * 
 *          输入: 2 输出: 91 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100)
 *          区间内的所有数字。
 */
public class UniqueNumber {
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 10;
		int sum = 10;
		int f = 9;
		for (int i = 2; i <= n; i++) {
			f *= (10 - i + 1);
			sum += f;
		}
		return sum;
	}
}
