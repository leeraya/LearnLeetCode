package leetcode;

import org.junit.Test;

/*
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
	P   A   H   N
	A P L S I I G
	Y   I   R
      之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 */
public class Z_zigzag {
	public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;			//小循环的模与行数有关
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
	
	@Test
	public void test1(){
		String s = "LKHUJGGGHJHNHFYT";
		s = convert(s, 3);
		System.out.println(s);
	}
}
