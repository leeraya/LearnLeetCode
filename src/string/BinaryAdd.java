package string;

import org.junit.Test;

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
	/*
	 * 总的思路是从低位向高位逐级相加，期间保存数值和对应的进位
	 */
	public String addBinary(String a, String b) {
		int i = a.length() - 1, j = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		int sum = 0, carry = 0; // sum % 2表示某位上的结果，sum / 2表示进位。
		while (i >= 0 || j >= 0) {
			sum = carry;	//carry是进位，存储前一次相加的结果的溢出
			if (j >= 0)
				sum += b.charAt(j--) - '0';		//一个char值 - '0' 等于对应的ascall码，例如：'a' - '0' = 49 ;
			if (i >= 0)
				sum += a.charAt(i--) - '0';

			sb.append(sum % 2);	
			carry = sum / 2;	//求进位
		}
		if (carry != 0)	//判断最后有没有溢出，如果有，sb就要加上这个溢出的值
			sb.append(carry);
		return sb.reverse().toString();		//StringBuilder的reverse()可以反转StringBuilder的内容
	}
	
	@Test
	public void test1(){
		System.out.println('a' - '0');
	}
}
