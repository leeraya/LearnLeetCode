package string;

/**
 * @author leeray
 * @version 创建时间：2019年3月23日 下午5:13:54 <br>
 *          描述：942. 增减字符串匹配<br>
 *          给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * 
 *          返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * 
 *          如果 S[i] == "I"，那么 A[i] < A[i+1] 如果 S[i] == "D"，那么 A[i] > A[i+1]
 */
public class DIString {
	/*
	 * 贪心法
	 */
	public int[] diStringMatch(String S) {
		int len = S.length();
		int[] A = new int[len + 1];
		int min = 0, max = S.length();

		for (int i = 0; i < len; i++) {
			if (S.charAt(i) == 'I')
				A[i] = min++;
			else
				A[i] = max--;

		}
		A[len] = min;
		return A;
	}
}
