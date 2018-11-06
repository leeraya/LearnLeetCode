package leetcode;

import org.junit.Test;

/**
 * 
 * @author Administrator
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 */
public class CheckPalindrome {
	public boolean isPalindrome(int x) {
		//首先，要排除负数，因为负数肯定不是回文的
		int rev = 0;		//用来存储反转后的值
		int temp = x;
		if(x < 0){
			return false;
		}else if(x == 0){
			return true;
		}else{
			while(temp > 0){
				rev = rev * 10 + temp % 10;
				temp /= 10;
				System.out.println(rev);
			}
		}
		if(x == rev){
			return true;
		}
		return false;
	}
	
	@Test
	public void test1(){
		int x = 121;
		isPalindrome(x);
	}
}
