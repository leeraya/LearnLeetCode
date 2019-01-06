package math;

/**
 * @author leeray
 * @version 创建时间：2019年1月6日 下午4:01:42 <br>
 *          描述：338. 比特位计数<br>
 *          给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class OneCounts {
	public int[] countBits(int num) {

		int res[] = new int[num + 1];

		for (int i = 0; i <= num; i++) {
			res[i] = OneCount(i);
		}
		return res;
	}

	// 求某个数的二进制中有多少个1的函数
	private int OneCount(int n) {
		int res = 0;
		while (n > 0) {
			res++;
			n &= (n - 1);
		}
		return res;
	}

	// 大神做法
	public int[] countBits_2(int num) {
		int[] res = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			res[i] = res[i / 2] + (i & 1);
		}
		return res;
	}
}
