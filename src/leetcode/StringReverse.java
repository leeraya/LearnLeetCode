package leetcode;

/**
 * 
 * @author Administrator 
 * 编写一个函数，其作用是将输入的字符串反转过来。
 */
public class StringReverse {
	public String reverseString(String s) {
		//利用StringBuilder的反转函数reverse()
		StringBuilder sb = new StringBuilder(s);
		sb = sb.reverse();
		s = sb.toString();
		return s;
	}
}
