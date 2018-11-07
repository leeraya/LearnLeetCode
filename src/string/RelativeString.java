package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 */
/*
 * 输入： A = "ab", B = "ba" 输出： true
 * 
 * 输入： A = "ab", B = "ab" 输出： false
 * 
 * 输入： A = "aa", B = "aa" 输出： true
 * 
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb" 输出： true
 * 
 * 输入： A = "", B = "aa" 输出： false
 */
public class RelativeString {
	public boolean buddyStrings(String A, String B) {
		
		// （1）两个字符串长度不同，直接返回false，len(A)==len(B)是亲密字符串的前提条件。
		if (A.length() == 0 || B.length() == 0)
			return false;
		if (A.length() != B.length())
			return false;

		// （2）当 A==B，字符串A中必须存在重复字符，否则无法完成一次交换，也就成不了亲密字符串。
		if (A.equals(B)) {
			Map<Character,Integer> map = new HashMap<Character, Integer>();
			for(int i = 0; i < A.length();i++){
				if(map.containsKey(A.charAt(i))){
					return true;
				}
				map.put(A.charAt(i), i);
			}
		}else{
			// （3）当 A != B,  此时要想成立，字符串A、B对应位置有两位不一样，且，交换之后一样。
			List<Integer> index = new ArrayList<>();	//用于记录不相同元素的下标index
			for(int j = 0; j < A.length(); j++){
				if(A.charAt(j) != B.charAt(j)){
					index.add(j);
				}
			}
			if(index.size() == 2 && A.charAt(index.get(0)) == B.charAt(index.get(1)) 
				&& B.charAt(index.get(0)) == A.charAt(index.get(1))){
				return true;
			}
		}
		return false;
	}
}
