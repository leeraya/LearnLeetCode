package dynamicProgramming;

import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2018年12月24日 下午6:35:52 <br>
 *          描述：139. 单词拆分<br>
 *          给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 
 *          说明：
 * 
 *          拆分时可以重复使用字典中的单词。 你可以假设字典中没有重复的单词。
 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s.length() == 0) {
			return true;
		} else if (wordDict.size() == 0) {
			return false;
		}
		int len = s.length();
		// dp[i]表示s中前i个字符是否可以由dict中的word组成
		boolean dp[] = new boolean[len + 1];
		dp[0] = true; // 前0个肯定可以匹配到
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				String temp = s.substring(j, i);
				//判断前i个字符能否有字典组成，要看从0到j是否能组成并且j到i的字符串在字典中
				if (dp[j] && wordDict.contains(temp)) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];
	}
}
