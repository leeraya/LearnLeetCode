package string;

/**
 * @author leeray
 * @version 创建时间：2019年3月21日 下午6:54:21 <br>
 *          描述：925. 长按键入<br>
 *          你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * 
 *          你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 */
public class LongPressedName {
	public boolean isLongPressedName(String name, String typed) {
		int i = 0;
		for (int j = 0; i < name.length() && j < typed.length(); j++) {
			if (name.charAt(i) == typed.charAt(j)) {
				i++;
			} else if (i == 0 || name.charAt(i - 1) != typed.charAt(j)) {
				// 这里i==0是判断两字符串开头就不同的情况
				return false;
			}
		}
		return i == name.length();
	}
}
