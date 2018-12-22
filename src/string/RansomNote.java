package string;

import java.util.Arrays;

/**
 * @author leeray
 * @version 创建时间：2018年12月22日 下午5:07:09 <br>
 *          描述：383. 赎金信<br>
 *          给定一个赎金信 (ransom)
 *          字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回
 *          true ；否则返回 false。
 * 
 *          (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 */
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.equals(magazine))
			return true;
		if (ransomNote.length() == 0)
			return true;
		if (magazine.length() == 0)
			return false;
		char[] rh = ransomNote.toCharArray();
		char[] mh = magazine.toCharArray();
		Arrays.sort(rh);
		Arrays.sort(mh);
		int j = 0;
		for (int i = 0; i < mh.length; i++) {
			if (j >= rh.length)
				break;
			if (rh[j] == mh[i]) {
				j++;
			}
		}
		return j == rh.length;
	}
}
