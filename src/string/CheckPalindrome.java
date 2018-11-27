package string;

import org.junit.Test;

/**
 * 125. 验证回文串 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1: 输入: "A man, a plan, a canal: Panama" 输出: true
 * 
 * 示例 2: 输入: "race a car" 输出: false
 */
public class CheckPalindrome {
	public boolean isPalindrome(String s) {
		if(s.length() == 0 || s.length() == 1) return true;
		return check(s);
	}
	
	//写判定回文的方法
	private boolean check(String s){
		s = s.toLowerCase();		//先全部转成小写，以后就不用验证大小写了。
		int len = s.length();
		int low = 0, high = len - 1;
		while(low <= high){			//这里=的情况是长度小于2时的
			if(s.charAt(low) == s.charAt(high)){	//如果左右相等，则都向中心移动
				low++; high--;					
			}else if(!Character.isLetterOrDigit(s.charAt(low))){
				//如果不相等，则判断它是不是除数字或字符以外的字符，如果是则继续向中心移动
				low++;
			}else if(!Character.isLetterOrDigit(s.charAt(high))){
				high--;
			}else{
				return false;
			}
		}
		return true;
	}
	/*
	 * 回文字符串的验证一般都是用双指针的的方式，首尾向中间聚集，依次验证。
	 * 如果有特殊要求：比如不管空格，, .等特殊字符，直接通过指针加一跳过即可
	 */
	@Test
	public void test1(){
		String s = "A man, a plan, a canal: Panama";
		String s1 = "a.";
		System.out.println(isPalindrome(s1));
		System.out.println(s);
	}
}
