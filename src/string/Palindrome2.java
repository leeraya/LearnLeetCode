package string;

import org.junit.Test;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 
 * 示例 1: 输入: "aba" 输出: True
 * 
 * 示例 2: 输入: "abca" 输出: True 解释: 你可以删除c字符。
 */
public class Palindrome2 {
	//------------------------------------------------------------//
	public boolean validPalindrome2(String s) {
        int i = 0,j = s.length() - 1;
        char[] chars = s.toCharArray();
        while(i < j){
            if(chars[i] != chars[j]){
                if(judge(chars,i+1,j)){
                    return true;
                }else if(judge(chars,i,j-1)){
                    return true;
                }else
                    return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    public boolean judge(char[] chars,int start,int end){
        while(start < end){
            if(chars[start] != chars[end])
                return false;
            start++;
            end--;
        }
        return true;
    }

	@Test
	public void test1() {
		
	}
}
