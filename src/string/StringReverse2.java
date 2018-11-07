package string;

/**
 * 
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于k 个字符，
 * 则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 */
/*
 * 输入: s = "abcdefg", k = 2 输出: "bacdfeg"
 */
public class StringReverse2 {
	public String reverseStr(String s, int k) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int index = 0;
        while(index < len){
            if(len - index > k){//当长度满足时
                for(int i = index,j = index + k -1;i < j;i++,j--){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
                index = index + 2*k;
            }else{//当长度不满足时，直接全部反转
                for(int i = index,j = len-1;i < j;i++,j--){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
                index = len;
            }
        }
        return new String(chars);
    }
}
