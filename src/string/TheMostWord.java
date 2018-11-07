package string;
import java.util.*;
/**
 * 给定一个段落 (paragraph) 和一个禁用单词列表
 * (banned)。返回出现次数最多，同时不在禁用列表中的单词。题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * 
 */
public class TheMostWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		HashSet<String> bannedSet = new HashSet<>();
		HashMap<String, Integer> wordsMap = new HashMap<>();
		String mcw = "";
		int mcwCount = -1;

		// filter spaces and punctuation
		String[] wordsArr = paragraph.toLowerCase().split(" |!|\\?|'|,|;|\\.");

		// put banned words into hash set
		for (String s : banned)
			bannedSet.add(s);

		// add and count non-banned words into wordsMap
		for (String s : wordsArr) {
			if (!bannedSet.contains(s) && !s.equals("")) {
				wordsMap.put(s, wordsMap.getOrDefault(s, 0) + 1);

				int count = wordsMap.get(s);
				// keep tracking the most common word
				if (count > mcwCount) {
					mcw = s;
					mcwCount = count;
				}
			}
		}
		return mcw;
	}
	
	//-----------------------------------------------//
	private final String removeSymbol(String str){
        char[] chars=str.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(char c:chars){
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public String mostCommonWord2(String paragraph, String[] banned) {
        HashMap<String,Integer> banMap=new HashMap<String,Integer>();
        for(String banStr:banned){
            banMap.put(banStr.toLowerCase(),1);
        }

        String paragraphArr[]=paragraph.split(" ");
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(String pa:paragraphArr){
            String t=removeSymbol(pa);
            if(banMap.get(t)==null){
                if(map.get(t)==null){
                    map.put(t,1);
                }
                else{
                    map.put(t,map.get(t)+1);
                }
            }
        }

        int max=0;
        String maxStr="";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue()>max){
                max=entry.getValue();
                maxStr=entry.getKey();
            }
        }
        return maxStr;

    }
}
