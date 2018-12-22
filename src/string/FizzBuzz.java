package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2018年12月22日 下午4:37:52 <br>
 *          描述：412. Fizz Buzz<br>
 *          写一个程序，输出从 1 到 n 数字的字符串表示。
 * 
 *          1. 如果 n 是3的倍数，输出“Fizz”；
 * 
 *          2. 如果 n 是5的倍数，输出“Buzz”；
 * 
 *          3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */
public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				res.add("FizzBuzz");
			} else if (i % 3 != 0 && i % 5 == 0) {
				res.add("Buzz");
			} else if (i % 3 == 0 && i % 5 != 0) {
				res.add("Fizz");
			} else {
				res.add(String.valueOf(i));
			}
		}
		return res;
	}
}
