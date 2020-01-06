package array;

import java.util.Arrays;

/**
 * @author leeray
 * @version 1.0
 * @date 2019/10/14 0014 8:42
 * <p>
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 * <p>
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 * <p>
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，
 * 其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 */
public class NumSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int answer[] = new int[queries.length];
        return null;
    }

    //建立一个函数，求每个f(s),返回数组形式

    //字符串排序
    private static void strSort(String str) {
        char[] chars = str.toCharArray();
        int [] nums = new int[chars.length];
    }

    public static void main(String[] args) {
        String str = "jhfsksnkfjwhoiasas";
        strSort(str);
        System.out.println(str);

        System.out.println('0'+1);
    }
}
