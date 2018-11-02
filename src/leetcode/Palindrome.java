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
			System.out.println("第" + i + "次调用");	//测试用
			i = expand2(cs, range, i);
		}
		return s.substring(range[0], range[1]);
	}

	private int expand(char[] cs, int[] range, int i) {
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
	//自己写了一遍
	private int expand2(char[] cs, int[] range, int i){
		//创建目标字串的首尾“指针”
		int low = i, high = i;
		int length = cs.length;	//获得cs数组的长度，作为循环的边界条件
		
		//第一步，首先要看i指的字符之后还有没有与它相同的，由于回文的特性，一排相同的字符肯定是回文的。
		while(high < length - 1 && cs[i] == cs[high + 1]){
			high++;			//指向最远的相同的字符
		}
		int res = high;		//这里是对循环的优化，一排最长的相同字符肯定要比它中间的的部分相同字符组成的回文要长
		while(low > 0 && high < length -1 && cs[low - 1] == cs[high + 1]){
			//当满足拓展条件，对目标字串做拓展
			low--; high++;
		}
		//判断目前的首尾距离与之前的大小，取最大值
		if((high - low + 1) > (range[1] - range[0])){
			range[0] = low;
			range[1] = high + 1;		//这里一定要加1,还是subString的问题
		}
		return res;
	}
	
	@Test
	public void strtest(){
		String str = "abaab";
		System.out.println(longestPalindrome(str));
		
	}
}
