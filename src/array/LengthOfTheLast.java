package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月20日 下午3:16:31 <br>
 *          描述：58. 最后一个单词的长度<br>
 *          给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 
 *          如果不存在最后一个单词，请返回 0 。
 * 
 *          说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 */
public class LengthOfTheLast {
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0)
			return 0;
		s = s.trim();	//去除首尾空格

		String[] ch = s.split(" ");

		return ch[ch.length - 1].length();
	}
}
