package string;

/**
 * @author leeray
 * @version 创建时间：2019年3月21日 下午7:06:12 <br>
 *          描述：926. 将字符串翻转到单调递增<br>
 *          如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有
 *          '1'）的形式组成的，那么该字符串是单调递增的。
 * 
 *          我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 * 
 *          返回使 S 单调递增的最小翻转次数。
 */
public class FlipsMonoIncr {
	/**
	 * 最后的形式是左边都是0，右边都是1，因此我们要遍历每一个元素，计算包括它的左边的1的个数和它的右边的0的个数的和
	 */
	public int minFlipsMonoIncr(String S) {
		int target = 0, ret = Integer.MAX_VALUE;
		char ch[] = S.toCharArray();
		int zero=0,one=0;
		for (int i = 0; i < ch.length; ++i) {
			//统计0，1的总的个数
			if(ch[i] =='0'){
				zero++;
			}else{
				one++;
			}
			
			// 统计包括该元素的左边的1的个数
			for (int j = 0; j <= i; ++j) {
				if (ch[j] == '1') {
					target++;
				}
			}
			// 统计右边的0的个数
			for(int k = ch.length - 1; k > i;--k){
				if(ch[k] == '0'){
					target++;
				}
			}
			ret = Math.min(ret, target);
			target = 0;
		}
		return Math.min(ret, Math.min(zero, one));
	}
}
