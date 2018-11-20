package string;

/**
 * @author leeray
 * @version 创建时间：2018年11月20日 下午4:40:17 <br>
 *          描述：<br>
 */
public class FindDifferent {
	public char findTheDifference(String s, String t) {
		s = sort(s);
		t = sort(t);

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i))
				return t.charAt(i);
		}
		return t.charAt(t.length() - 1);
	}

	public String sort(String str) {
		// 利用toCharArray可将字符串转换为char型的数组
		char[] s1 = str.toCharArray();
		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < i; j++) {
				if (s1[i] < s1[j]) {
					char temp = s1[i];
					s1[i] = s1[j];
					s1[j] = temp;
				}
			}
		}
		// 再次将字符数组转换为字符串，也可以直接利用String.valueOf(s1)转换
		String st = new String(s1);
		return st;
	}
	// ------------------------------//

	public char findTheDifference_2(String s, String t) {
		int[] array = new int[26];

		for (int i = 0; i < s.length(); i++) {
			array[s.charAt(i) - 'a'] += 1;
		}

		int i = 0;

		for (i = 0; i < t.length(); i++) {
			if (array[t.charAt(i) - 'a'] <= 0) {
				break;
			} else {
				array[t.charAt(i) - 'a'] -= 1;
			}
		}

		return t.charAt(i);
	}
}
