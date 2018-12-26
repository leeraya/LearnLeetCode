package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author leeray
 * @version 创建时间：2018年12月26日 下午4:19:03 <br>
 *          描述：409. 最长回文串<br>
 * 			给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 
 *          在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 
 *          注意: 假设字符串的长度不会超过 1010。
 */
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		if(s == null || s.length() == 0){
			return 0;
		}
		int len = s.length() , pl = 0;
		char [] ch = s.toCharArray();
		Map<Character , Integer> alphbat = new HashMap<Character , Integer>();
		//将各字母出现的个数装入map中
		for(char c : ch){
			if(alphbat.containsKey(c)){
				alphbat.put(c , alphbat.get(c) + 1);
			}else{
				alphbat.put(c, 1);
			}
		}
		//遍历map
		for(Map.Entry<Character , Integer> en : alphbat.entrySet()){
			//偶数个字母可以直接加入回文串中
			if(en.getValue() % 2 == 0){
				pl += en.getValue();
			}else {
				pl += en.getValue() - 1;
			}
		}
		//处理多余的单个的字母
		if(pl < len){
			pl++;
		}
		return pl;
	}
}
