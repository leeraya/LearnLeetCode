package stack;

import java.util.Stack;

/**
 * @author leeray
 * @version 创建时间：2019年1月4日 下午5:08:10 <br>
 *          描述：844. 比较含退格的字符串<br>
 *          给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 */
public class BackspaceStr {
	public boolean backspaceCompare(String S, String T) {
		if (S == null || S.length() == 0) {
			return false;
		}
		if (T == null || T.length() == 0) {
			return false;
		}
		char sh[] = S.toCharArray(), th[] = T.toCharArray();
		String rs = "", rt = "";
		Stack<Character> stack = new Stack<Character>();
		for (char c1 : sh) {
			if (c1 == '#') {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(c1);
			}
		}
		while (!stack.isEmpty()) {
			rs += stack.pop();
		}
		stack.clear();
		for (char c2 : th) {
			if (c2 == '#') {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(c2);
			}
		}
		while (!stack.isEmpty()) {
			rt += stack.pop();
		}
		return rs.equals(rt);
	}
}
