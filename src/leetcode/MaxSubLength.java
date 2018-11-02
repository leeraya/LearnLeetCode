package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 */
public class MaxSubLength {
	
	//滑动窗口法
	public int lengthOfLongestSubstring2(String s){
		if(s == null || s.length() == 0) return 0;
		int maxlength=0;		//用来存储子串最大长度
		int strLen = s.length();
		int left=0,right=0;			//作为滑动窗口的边界
		Set<Character> set = new HashSet<>();	//作为窗口判断重复
		while(left < strLen&&right < strLen){
			if(set.contains(s.charAt(right))){	//如果遇到相同的元素，就删除Set中对应的元素
				set.remove(s.charAt(left));
				left++;
			}else{
				set.add(s.charAt(right));
				right++;
				maxlength = Math.max(maxlength, right-left);
			}
		}
		return maxlength;
		
	}
}
