package string;

/**
 * @author leeray
 * @version 1.0
 * @date 2019/9/20 0020 14:26
 * niuke
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        return s.replaceAll(" ", "%20");
    }
}
