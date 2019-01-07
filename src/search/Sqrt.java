package search;

/**
 * @author leeray
 * @version 创建时间：2019年1月7日 下午5:01:49 <br>
 *          描述：69. x 的平方根<br>
 *          实现 int sqrt(int x) 函数。
 * 
 *          计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 *          由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Sqrt {
	public int mySqrt(int x) {
		if (x <= 1) {
			return x;
		}

		int left = 1, right = x;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid == x / mid) {//防止溢出
				return mid;
			} else {
				if (mid < x / mid) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return right;
	}
}
