package math;

/**
 * @author leeray
 * @version 创建时间：2018年12月20日 下午4:45:10 <br>
 *          描述：326. 3的幂<br>
 *          给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */
public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		if (n <= 0)
			return false;
		return 1162261467 % n == 0;
	}
}
