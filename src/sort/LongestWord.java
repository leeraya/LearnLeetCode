package sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2018年12月18日 下午7:38:55 <br>
 *          描述：524. 通过删除字母匹配到字典里最长单词<br>
 *          给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。<br>
 *          如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 */
public class LongestWord {
	public String findLongestWord(String s, List<String> d) {
        if(s == null || s.length() == 0)
            return s;
               
        //排序
       Collections.sort(d , new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length()){
					return -1;
				}else if(o1.length() == o2.length()){
					return o1.compareTo(o2);
				}
				return 1;
			}
		});
        
        for(int i = 0; i < d.size(); i++){
            if(isWord(s , d.get(i)))
                return d.get(i);
        }
        return "";
    }
               
    private boolean isWord(String str , String pattern){
        int j = 0;
        for(int i = 0; i < str.length(); i++){
            if(j >= pattern.length())
                break;
            if(str.charAt(i) == pattern.charAt(j)){
                j++;
            }
        }
        return j == pattern.length();
    }
}
