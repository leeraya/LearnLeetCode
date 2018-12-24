package math;

import org.junit.Test;

/**
 * @author leeray
 * @version 创建时间：2018年12月23日 下午7:00:08 <br>
 *          描述：204. 计数质数<br>
 *          统计所有小于非负整数 n 的质数的数量。
 */
public class PrimeNumbers {

	// 第一种方法超时
	public int countPrimes(int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (isPrime(i)) {
				count++;
				// System.out.print(i + "\t");测试
			}

		}
		return count;
	}

	// 判断是否为质数
	private boolean isPrime(int n) {
		boolean ret = true;
		if (n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 != 0) {
			int border = (int) (Math.sqrt(n) + 1);
			for (int i = 2; i < border; i++) {
				if (n % i == 0) {
					return false;
				}
			}
		} else {
			ret = false;
		}
		return ret;
	}

	// ---------------------------//
	/*
	 * 厄拉多塞筛法 :一个素数p只有1和p这两个约数，并且它的约数一定不大于其本身。因此，我们下边方法来筛选出来素数：
	 * 
	 * 1）把从2开始的、某一范围内的正整数从小到大顺序排列；2）剩下的数中选择最小的素数，然后去掉它的倍数.
	 * 
	 * 3）依次类推，直到循环结束。
	 */
	public int countPrimes_2(int n) {
		if (n <= 1) {
			return 0;
		}
		boolean[] a = new boolean[n];// 是素数
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (a[i] == false) {// 是素数
				count++;
				for (int j = 2; j * i < n; j++) {
					a[j * i] = true;
				}
			}
		}
		return count;
	}

	@Test
	public void test() {
		System.out.println(isPrime(Integer.MAX_VALUE));
		System.out.println(countPrimes_2(1500000));
	}
}
