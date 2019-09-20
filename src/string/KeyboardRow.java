package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author leeray
 * @version 1.0
 * @date 2019/9/20 0020 13:25
 * 500. 键盘行
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
 * 示例：
 * <p>
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        Set<Integer> lines = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                lines.add(getLine(c));
                if (lines.size() > 1) {
                    break;
                }
            }
            if (lines.size() == 1) {
                list.add(word);
            }
            lines.clear();
        }
        if (list.size() == 0)
            return new String[0];
        else {
            return list.toArray(new String[list.size()]);
        }
    }

    private static int getLine(Character character) {
        String temp = ("" + character).toUpperCase();
        String one = "QWERTYUIOP";
        String two = "ASDFGHJKL";
        String three = "ZXCVBNM";
        if (one.contains(temp)) {
            return 1;
        } else if (two.contains(temp)) {
            return 2;
        } else if (three.contains(temp)) {
            return 3;
        }
        return 0;
    }
}
