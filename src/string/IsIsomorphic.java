package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leeray
 * @version 1.0
 * @date 2020/1/6 0006 10:12
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (s.indexOf(chars[i]) != t.indexOf(chart[i])) {
                return false;
            }
        }
        return true;
    }

    //用哈希表做
    public boolean isIsomorphic1(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }


    public boolean isIsomorphicHelper(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < chars.length; i++) {
            //遍历chars和chart
            if (map.containsKey(chars[i])) {
                //map中包含key,比较key对应的value与当前chart[i]十分相同
                if (map.get(chars[i]) != chart[i]) {
                    return false;
                }
            } else {
                //map中不包含key
                map.put(chars[i], chart[i]);
            }
        }
        return true;
    }
}
