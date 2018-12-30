package math;

/**
 * @author leeray
 * @version 创建时间：2018年12月30日 下午5:36:44 <br>
 *          描述：507. 完美数<br>
 *          对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * 
 *          给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False
 */
public class PerfectNumber {
	public boolean checkPerfectNumber(int num) {
		if (num == 1)
			return false;
		int sum = 1;
		//一个数的所有因子，一半在sqrt(num)左边，一半在右边。只需要遍历到sqrt(num)，在每次看到符合条件
		//就将i 与 对应另一边的因子 num / i 加入和中
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				sum += i + num / i;
			}
		}
		return num == sum;
	}
}
