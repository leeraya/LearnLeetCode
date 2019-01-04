package stack;

import java.util.Stack;

import org.junit.Test;

/**
 * @author leeray
 * @version 创建时间：2019年1月4日 下午2:10:19 <br>
 *          描述：150. 逆波兰表达式求值<br>
 *          根据逆波兰表示法，求表达式的值。
 * 
 *          有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 
 *          说明：
 * 
 *          整数除法只保留整数部分。 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class EvalRPN {
	public int evalRPN(String[] tokens) {
		// 其实就是后缀表达式求值
		// 主要考察栈的使用
		Stack<Integer> s = new Stack<Integer>();

		for (String str : tokens) {
			// 在遍历数组的过程中，遇到数字就直接压栈，碰到操作符就将栈中前两个元素取出，执行操作符的运算
			// 并将结果返回到栈中
			switch (str) {
			case "+":
				s.push(s.pop() + s.pop());
				break;
			case "-":
				int temp1 = s.pop();
				s.push(s.pop() - temp1);
				break;
			case "*":
				s.push(s.pop() * s.pop());
				break;
			case "/":
				int temp2 = s.pop();
				s.push(s.pop() / temp2);
				break;
			default:
				s.push(Integer.parseInt(str));
				break;
			}
		}
		return s.pop();
	}

	// 测试
	@Test
	public void test1(){
		String [] strs = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.println(evalRPN(strs));
	}
}
