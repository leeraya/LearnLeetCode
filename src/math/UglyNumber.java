package math;

/**
 * @author leeray
 * @version 创建时间：2018年12月26日 下午4:03:24 <br>
 *          描述：263. 丑数<br>
 *          编写一个程序判断给定的数是否为丑数。
 * 
 *          丑数就是只包含质因数 2, 3, 5 的正整数。
 */
public class UglyNumber {
	// 递归算法的时间消耗较大
	public boolean isUgly(int num) {
		if (num == 0)
			return false;
		if (num == 1)
			return true;
		if (num % 2 == 0) {
			num /= 2;
			return isUgly(num);
		}
		if (num % 3 == 0) {
			num /= 3;
			return isUgly(num);
		}
		if (num % 5 == 0) {
			num /= 5;
			return isUgly(num);
		}
		return false;
	}
	
	// 直接将num中的2,3,5因子除去，看最后结果是否为1
	public boolean isUgly_2(int num) {
		if (num == 0) {
			return false;
		}
		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 3 == 0) {
			num /= 3;
		}
		while (num % 5 == 0) {
			num /= 5;
		}
		return num == 1;
	}
}
