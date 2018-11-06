package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * 
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 */
/*
 * 示例1:
 * 
 * 输入: pattern = "abba", str = "dog cat cat dog" 输出: true
 * 
 * 示例 2:
 * 
 * 输入:pattern = "abba", str = "dog cat cat fish" 输出: false
 */
public class WordsPattern {
	public boolean wordPattern(String pattern, String str) {
		boolean flag = true;
		
		int pl = pattern.length();
		
		String [] s = str.split(" ");
		//如果经处理过后的s的长度不等于pl，那么它们肯定不能匹配，直接返回false
		if(pl != s.length){
			return false;
		}
		boolean ptdp[][] = new boolean[pl][pl];
		boolean strdp[][] = new boolean[s.length][s.length];
		
		for(int i = 0; i < pl; i++){
			for(int j = 0; j < pl; j++){
				if(pattern.charAt(i) == pattern.charAt(j)){
					ptdp[i][j] = true;
				}
			}
		}
			
		for(int i = 0; i < s.length; i++){
			for(int j = 0; j < s.length; j++){
				if(s[i].equals(s[j])){
					strdp[i][j] = true;
				}
			}
		}
				
		for(int i = 0;i < s.length;i++){
			for(int j = 0;j < s.length;j++){
				if(ptdp[i][j] != strdp[i][j]){
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	@Test
	public void test1(){
		String p ="abba" ,str = "dog cat cat dog";
		System.out.println(wordPattern(p, str));
	}
}
