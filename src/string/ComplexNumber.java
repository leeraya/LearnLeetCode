package string;

/**
 * @author leeray
 * @version 创建时间：2018年12月17日 下午7:19:05 <br>
 *          描述：537. 复数乘法<br>
 *          给定两个表示复数的字符串。
 * 
 *          返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 */
public class ComplexNumber {
	public String complexNumberMultiply(String a, String b) {
		//利用正则表达式，将复数的实部和虚部分割出来。
		String x[] = a.split("\\+|i");
		String y[] = b.split("\\+|i");

		int a_real = Integer.parseInt(x[0]);
		int a_vir = Integer.parseInt(x[1]);

		int b_real = Integer.parseInt(y[0]);
		int b_vir = Integer.parseInt(y[1]);

		return (a_real * b_real - a_vir * b_vir) + "+" + (a_real * b_vir + a_vir * b_real) + "i";
	}
}
