package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2018年11月28日 上午10:46:33 <br>
 *          描述：345. 反转字符串中的元音字母<br>
 *          编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 *          示例 1:
 * 
 *          输入: "hello" 输出: "holle" <br>
 *          示例 2:
 * 
 *          输入: "leetcode" 输出: "leotcede"
 */
/*
 * 只反转元音字母，就是只看字符串中的元音字母，以这个顺序来反转它们，而非元音字母则原地不动。
 * 我的思路是先取出字符串中所有的元音字母，然后遍历原字符串，将非元音字母加入StringBuilder,遇到有元音字母的位置，则倒序插入元音字母。
 */
public class ReverseVowels {
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0)
			return s;
		char[] ch = s.toCharArray();
		List<Character> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		// 先取出所有元音字母存储在list中
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' || ch[i] == 'A'
					|| ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U') {
				list.add(ch[i]);
			}
		}
		int index = list.size() - 1;
		// 遍历ch,将非元音字母按序加入sb,若遇到元音字母，则将list尾部的元素加入，索引向前移动。
		for (int j = 0; j < ch.length; j++) {
			if (ch[j] == 'a' || ch[j] == 'e' || ch[j] == 'i' || ch[j] == 'o' || ch[j] == 'u' || ch[j] == 'A'
					|| ch[j] == 'E' || ch[j] == 'I' || ch[j] == 'O' || ch[j] == 'U') {
				sb.append(list.get(index--));
			} else {
				sb.append(ch[j]);
			}
		}
		return sb.toString();
	}
}
