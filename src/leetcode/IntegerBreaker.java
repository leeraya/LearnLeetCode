package leetcode;
/**
 * 
 * @author Administrator
 *	整数划分原理：尽可能多划分出3来
 *  2 = 1 + 1 mul = 1
 *  3 = 2 + 1 mul = 2 * 1 = 2
 *  4 = 2 + 2 or 3 + 1 mul = 2 * 2 = 4 or 3 * 1 = 3
 *  5 = 2 + 3 mul = 2 * 3 = 6
 *  6 = 2 + 2 + 2 or 3 + 3 mul = 2*2*2 = 8 or 3*3 = 9
 *  总结规律：当n<4时，return n-1
 *  		  当n>=4时，若k = n%3 = 1,将其转换成k-1 和 4
 *  		                    若k = 2 ro 0 ,则保持最多3的策略
 */
public class IntegerBreaker {
	public int integerBreak(int n){
		if(n < 4){
			return n - 1;
		}
		if(n % 3 == 0){
			return (int) Math.pow(3, n / 3);
		}else if(n % 3 == 1){
			return (int) Math.pow(3, (n /3) -1) * 4;
		}else if(n % 3 == 2){
			return (int) Math.pow(3,n / 3) * 2;
		}
		return n;
	}
}
