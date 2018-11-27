package string;

/**
 * @author leeray
 * @version 创建时间：2018年11月27日 下午3:37:49 <br>
 *          描述：67. 二进制求和<br>
 *          给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 *          输入为非空字符串且只包含数字 1 和 0。
 * 
 *          示例 1:
 * 
 *          输入: a = "11", b = "1" 输出: "100" <br>
 *          示例 2:
 * 
 *          输入: a = "1010", b = "1011" 输出: "10101"
 */
public class BinaryAdd {
	public String addBinary(String a, String b) {
		int i = a.length() - 1, j = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		int sum = 0, carry = 0; // sum % 2表示某位上的结果，sum / 2表示进位。
		while (i >= 0 || j >= 0) {
			sum = carry;
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			if (i >= 0)
				sum += a.charAt(i--) - '0';

			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}
}
