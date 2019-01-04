package stack;

import java.util.Stack;

import org.junit.Test;

/**
 * @author leeray
 * @version 创建时间：2019年1月4日 下午7:33:31 <br>
 *          描述：20. 有效的括号<br>
 *          给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 *          有效字符串需满足：
 * 
 *          左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return true;
		char[] ch = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (char c : ch) {
			// 只有左括号会入栈
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				// 如果是对应的括号，则将栈顶的元素弹出
				if (isRight(stack.peek(), c)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		if (stack.isEmpty())
			return true;
		return false;
	}

	// 判断是否为对应闭合括号
	private boolean isRight(char c1, char c2) {
		if (c1 == '(' && c2 == ')')
			return true;
		if (c1 == '[' && c2 == ']')
			return true;
		if (c1 == '{' && c2 == '}')
			return true;
		return false;
	}

	@Test
	public void test() {
		System.out.println('{' - ']');
	}
}
