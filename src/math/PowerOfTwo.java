package math;

/**
 * @author leeray
 * @version 创建时间：2018年12月20日 下午5:56:57 <br>
 *          描述：231. 2的幂<br>
 */
/*
 * 2的幂的数字都有一个特点，就是二进制表示中都只有一个0
 * 如果这个数是2的幂，那么让它减一，然后与原来的按位与，所得的结果是0
 */
public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		return (n & (n - 1)) == 0;
	}
}
