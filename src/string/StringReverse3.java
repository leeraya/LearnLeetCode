package string;

import org.junit.Test;

/**
 * 
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 
 * 示例 1: 输入: "Let's take LeetCode contest" 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 */
public class StringReverse3 {
	//---------------------------------------------------//
	private void reverse(char[] chars, int start, int end){
        while(start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            ++start;
            --end;
        }
        return;
    }
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        for(char ch : chars){
            if(ch != ' '){
                ++end;
            }
            else{
                reverse(chars, start, end - 1);
                ++end;
                start = end;
            }
        }
        //由于上面的循环直到最后一个' '就结束，所以要对最后一个没有处理的进行反转操作
        reverse(chars, start, end - 1);
        return String.valueOf(chars);
    }
    
    //-------------------------------------//
    public String reverseWords2(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }

	@Test
	public void test1(){
		String str = "Let's take LeetCode contest";
		String rev = reverseWords(str);
		System.out.println(rev);
	}
}
