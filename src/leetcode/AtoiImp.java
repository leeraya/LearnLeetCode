package leetcode;

import org.junit.Test;

/**
 * 实现 atoi，将字符串转为整数。

该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。如果第一个非空字符是正号或负号，选取该符号，

并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。

当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。

若函数不能执行有效的转换，返回 0。

说明：

假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class AtoiImp {
	 public int myAtoi(String str) {
		    str = str.trim();
		    if (str.isEmpty()) return 0;
		    if(Character.isAlphabetic(str.charAt(0))) return 0;//如果开头的是字母，那么直接返回0
		    
		    // 正负号标记
		    int sign = 1;
		 
		    // 转换值
		    int base = 0;
		 
		    // 索引位数
		    int i = 0;
		 
		    // 判断正负号
		    if (str.charAt(i) == '-' || str.charAt(i) == '+')
		        sign = str.charAt(i++) == '-' ? -1 : 1;
		    //判断如果除开头有+-号以外，其他位置是否还有，如果有，就直接返回0
		    for(int j = 1;j <str.length(); j++){
		    	if(str.charAt(j) == '+' || str.charAt(j) == '-'){
		        	return 0;
		        }
		    }
		    // 索引有效数字字符
		    while (i < str.length()) {
		    	
		    	if(str.charAt(i) == '.'){
		        	return base * sign;
		        }
		        // 如果base > MAX_VALUE/10，那么base*10 + new_value > base*10 > MAX_VALUE，这种情况下就会发生溢出。
		        // 若base == INT_MAX/10，而且new_value = str.charAt(i++) - '0'`大于`7`，也会发生溢出。因为MAX_VALUE = 2147483647
		        if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
		            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		        }
		        
		        if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
		        	// 计算转换值
			        base = 10 * base + (str.charAt(i) - '0');
		        }
		        i++;
		    }
		 
		    // 计算结果值
		    return base * sign;
		    }
	 public int myAtoi2(String str) {
	    	if(str==null || "".equals(str)) return 0;
	        char[] s=str.toCharArray();
	        long sum=0;
	        int flag=1,status=0;
	        for(char c : s)
	        {
	        	if(status==0) 
	        	{
	        		if(c==' ') continue;
	        		else if(c!='+' && c!='-' && (c<'0'|| c>'9')) break;
	        		else
	        		{
	        			status=1;
	        			if(c=='-') flag=-1;
	        			else if(c>='0' && c<='9') sum=sum*10+(c-'0');
	        			continue;
	        		}
	        	}
	        	if(status==1)
	        	{
	                if(sum>Integer.MAX_VALUE) break;
	        		if(c>='0' && c<='9') sum=sum*10+(c-'0');
	        		else break;
	        	}
	        }
	        sum=sum*flag;
	        if(sum<Integer.MIN_VALUE) return Integer.MIN_VALUE;
	        else if(sum>Integer.MAX_VALUE) return Integer.MAX_VALUE;
	        else return (int)sum;      
	}
	@Test
	public void test() {
		String str = "  -001-2-a42";
		int a =myAtoi2(str);
		System.out.println(a);
	}
}
