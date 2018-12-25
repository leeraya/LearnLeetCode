package array;

/**
 * @author leeray
 * @version 创建时间：2018年12月25日 下午4:51:19 <br>
 *          描述：392. 判断子序列<br>
 */
/**
 * 
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。<br/>
 * 
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 */
public class IsSubSequene {
	public boolean isSubsequence(String s, String t) {
		int j = 0;
		for (int i = 0; i < t.length(); i++) {
			if (j >= s.length()) {
				break;
			}
			if (s.charAt(j) == t.charAt(i)) {
				j++;
			}
		}
		return j == s.length();
	}
}
