package string;

/**
 * @author leeray
 * @version 创建时间：2018年11月28日 上午10:28:41 <br>
 *          描述：28. 实现strStr()<br>
 *          实现 strStr() 函数。
 * 
 *          给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 *          (从0开始)。如果不存在，则返回 -1。
 * 
 *          示例 1:
 * 
 *          输入: haystack = "hello", needle = "ll" 输出: 2 <br>
 *          示例 2:
 * 
 *          输入: haystack = "aaaaa", needle = "bba" 输出: -1 <br>
 *          说明:
 * 
 *          当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 *          对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf()
 *          定义相符。
 */
public class IndexOf {
	public int strStr(String haystack, String needle) {
		// 首先判断needle
		if (needle == null || needle.length() == 0)
			return 0;
		if (haystack == null || haystack.length() < needle.length())
			return -1;
		char[] hay = haystack.toCharArray();
		char[] nd = needle.toCharArray();
		char first = nd[0];
		int hl = hay.length, nl = nd.length;
		for (int i = 0; i < hl; i++) {
			if (hay[i] != first) {
				continue; // 一直找到第一个元素相等的地方，然后判断其后的元素也是不是相等的
			} else {
				boolean flag = true;
				if (hl - i < nl) {
					// 此时虽然相等，但是长度已经不满足了，再往下也没有意义，直接退出循环
					break;
				}
				// 接下来判断i之后的若干元素是否相等
				for (int k = 0; k < nl; k++) {
					if (hay[i + k] != nd[k]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					return i;
				}
			}
		}
		return -1;
	}
}
