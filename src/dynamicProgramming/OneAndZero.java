package dynamicProgramming;

/**
 * @author leeray
 * @version 创建时间：2018年12月26日 上午11:32:38 <br>
 *          描述：474. 一和零<br>
 * 			在计算机界中，我们总是追求用有限的资源获取最大的收益。
 * 
 *          现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * 
 *          你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 * 
 *          注意:
 * 
 *          给定 0 和 1 的数量都不会超过 100。 给定字符串数组的长度不会超过 600。
 */
public class OneAndZero {
	public int findMaxForm(String[] strs, int m, int n) {
		if(strs == null || strs.length == 0)
			return 0;
		int dp[][] = new int[m + 1][n + 1];
		for(String str : strs){
			int ones = 0, zeros = 0;//记录每个字符串的0/1数量
			for(int k = 0; k < str.length(); k++){
				if(str.charAt(k) == '1'){
					++ones;
				}else{
					++zeros;
				}
			}
			for(int i = m; i >= zeros; --i){
				for(int j = n; j >= ones; --j){
					dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
				}
			}
		}
		return dp[m][n];
	}
}
