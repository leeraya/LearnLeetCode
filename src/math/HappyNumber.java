package math;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leeray
 * @version 创建时间：2018年12月23日 下午6:42:43 <br>
 *          描述：202. 快乐数<br>
 *          编写一个算法来判断一个数是不是“快乐数”。 一个“快乐数”定义为：<br>
 *          对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和， 然后重复这个过程直到这个数变为 1，<br>
 *          也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> got = new HashSet<Integer>();
		//得到的平方和在之前的循环中出现过，那以后会一直循环，不可能达到1。
		while (n != 1 && !got.contains(n)) {
			got.add(n);
			int sum = 0;
			while (n > 0) {
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			n = sum;
		}
		return n == 1;
	}
}
