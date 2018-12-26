package math;

/**
 * @author leeray
 * @version 创建时间：2018年12月26日 下午5:03:40<br>
 *          描述： 461. 汉明距离<br>
 *          两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 
 *          给出两个整数 x 和 y，计算它们之间的汉明距离。
 */
public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int xor = x ^ y;
		int oneCount = Integer.bitCount(xor);
		return oneCount;
	}
	//也可以不用库函数,用位运算，计算x和y异或的结果中有多少个1
	//有多少个1可以用n&(n-1)来求得
	public int hammingDistance_2(int x, int y) {
		int xor = x ^ y;
		int oneCount = 0;
		while(xor > 0){
			++oneCount;
			xor &= xor - 1;
		}
		return oneCount;
	}
}
