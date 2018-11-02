package leetcode;

import org.junit.Test;

/**
 * @author leeray 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 */
public class Palindrome {
	public String longestPalindrome(String s) {
		if (s.length() < 1) {
			return "";
		}
		char[] cs = s.toCharArray();
		int[] range = new int[] { 0, 1 };	//记录最长回文首尾索引
		for (int i = 0; i < cs.length; i++) {
			i = help(cs, range, i);
		}
		return s.substring(range[0], range[1]);
	}

	private int help(char[] cs, int[] range, int i) {
		int lo = i, hi = i;
		// 找到i后第一个不同处
		while (hi < cs.length - 1 && cs[hi] == cs[hi + 1])
			hi++;
		// 开始比较
		int ret = hi;
		while (lo > 0 && hi < cs.length - 1 && cs[lo - 1] == cs[hi + 1]) {
			lo--;
			hi++;
		}
		// 使range数组保存最大范围
		if ((hi - lo + 1) > (range[1] - range[0])) {
			range[0] = lo;
			range[1] = hi + 1;	//java算头不算尾，所以要加1，主要是用在substring时防止算错长度
		}
		return ret;
	}
	
	@Test
	public void strtest(){
		String str = "abbabccdeedc";
		System.out.println(longestPalindrome(str));
	}
}
