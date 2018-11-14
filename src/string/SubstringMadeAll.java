package string;

/**
 * 
 * 459. 重复的子字符串:给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 
 * 示例 1:
 * 
 * 输入: "abab"
 * 
 * 输出: True
 * 
 * 解释: 可由子字符串 "ab" 重复两次构成。 示例 2:
 * 
 * 输入: "aba"
 * 
 * 输出: False 示例 3:
 * 
 * 输入: "abcabcabcabc"
 * 
 * 输出: True
 * 
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class SubstringMadeAll {
	public boolean repeatedSubstringPattern(String s) {
        // 判断鲁棒性
        if (s == null || s.length() <= 1) {
            return false;
        }
        int length = s.length();
        // 循环判断
        for (int i = length/2; i > 0; i--) {
            // 判断是否满足重复子串
            if (length % i == 0) {
                StringBuilder sb = new StringBuilder();
                // 得到重复子串的个数
                int c = length / i;
                String temp = s.substring(0, i);
                for (int j = 0; j < c; j++) {
                   // 利用StringBuilder 拼接
                    sb.append(temp);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
	
	//--------------小小的优化:if判断len != 0之后跳过下面的代码，直接进行下一次循环------//
	public boolean repeatedSubstringPattern_2(String s) {
	      if(s.length() == 0 || s == null) return false;
	    int len = s.length();
	    //从n / 2开始减小字串的长度
	    for(int i = len / 2;i > 0; i--){
	        //从长度验证
	        if(len % i != 0) continue;
	        StringBuilder sb = new StringBuilder();
	        int num = len / i;//获得字串的个数
	        String sub = s.substring(0,i);		//获得子串
	        for(int j = 0; j < num; j++){
	            sb.append(sub);					//将字串拼接
	        }
	        if(sb.toString().equals(s)) return true;
	    }
	    return false;
	}
}
