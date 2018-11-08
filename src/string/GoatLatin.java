package string;

/**
 * 
 * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 * 
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 * 
 * 山羊拉丁文的规则如下：
 * 
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。 例如，单词"apple"变为"applema"。
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。 例如，单词"goat"变为"oatgma"。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * 返回将 S 转换为山羊拉丁文后的句子
 *
 */
public class GoatLatin {
	public String toGoatLatin(String S) {
		String[] s = S.split(" ");// 将S转换成字符串数组，以空格分开
		int count = 1;
		for (int i = 0; i < s.length; i++) {
			char a[] = s[i].toCharArray();
			if (a[0] == 'a' || a[0] == 'e' || a[0] == 'i' || a[0] == 'o' || a[0] == 'u' || a[0] == 'A' || a[0] == 'E'
					|| a[0] == 'I' || a[0] == 'O' || a[0] == 'U') {
				s[i] = s[i] + "ma";
			} else {
				s[i] = s[i].substring(1, s[i].length()) + a[0] + "ma";
			}
			for (int j = 0; j < count; j++) {
				s[i] += 'a';
			}
			count++;
		}
		S = "";
		for (int i = 0; i < s.length; i++) {
			if (i != s.length - 1)
				S += s[i] + " ";
			else
				S += s[i];
		}
		return S;
	}

	// -------------------------------------------//
	public String toGoatLatin2(String S) {
		StringBuilder sb = new StringBuilder();
		char[] arr = S.toCharArray();
		char pre = ' ';
		int index = 0;
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || arr[i - 1] == ' ') {
				index++;
				pre = arr[i];
				char tmp = Character.toLowerCase(pre);
				if ((tmp == 'a') || (tmp == 'e') || (tmp == 'i') || (tmp == 'o') || (tmp == 'u')) {
					flag = true;
					sb.append(pre);
				}
			} else if (i == arr.length || (arr[i] == ' ')) {
				if (!flag) {
					sb.append(pre);
				}
				sb.append("ma");
				for (int k = 0; k < index; k++) {
					sb.append("a");
				}
				flag = false;
				sb.append(" ");
			} else {
				sb.append(arr[i]);
			}
		}
		if (arr[arr.length - 1] != ' ') {
			if (!flag) {
				sb.append(pre);
			}
			sb.append("ma");
			for (int k = 0; k < index; k++) {
				sb.append("a");
			}
		}
		String res = sb.toString();
		return res;
	}
}
