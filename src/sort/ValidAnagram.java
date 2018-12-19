package sort;

import java.util.Arrays;

/**
 * @author leeray
 * @version 创建时间：2018年12月19日 下午2:39:06 <br>
 *          描述：242. 有效的字母异位词<br>
 *          给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。 给定两个字符串 s 和 t ，编写一个函数来判断
 *          t 是否是 s 的一个字母异位词。
 * 
 *          示例 1:
 * 
 *          输入: s = "anagram", t = "nagaram" 输出: true
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() == 0 && t.length() == 0)
			return true;
		if (s.length() != t.length())
			return false;
		char[] sh = s.toCharArray();
		char[] th = t.toCharArray();

		int len1 = sh.length;
		Arrays.sort(sh);
		Arrays.sort(th);
		// 对位检查是否相同
		int equl = 0;
		for (int i = 0; i < len1; i++) {
			if (sh[i] == th[i]) {
				equl++;
			} else {
				break;
			}
		}
		if (equl == sh.length)
			return true;
		return false;
	}

	// ------------------------------//
	public boolean isAnagram_2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] sInt = new int[26];
		int[] tInt = new int[26];
		for (int i = 0; i < s.length(); i++) {
			sInt[s.charAt(i) - 97]++;
			tInt[t.charAt(i) - 97]++;
		}
		for (int i = 0; i < 26; i++) {
			if (sInt[i] != tInt[i]) {
				return false;
			}
		}
		return true;
	}
}
