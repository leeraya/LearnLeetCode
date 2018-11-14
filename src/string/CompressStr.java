package string;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 
 * 443. 压缩字符串: 给定一组字符，使用原地算法将其压缩。
 * 
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 
 * 在完成原地修改输入数组后，返回数组的新长度。
 * 
 * 进阶： 你能否仅使用O(1) 空间解决问题？
 */
public class CompressStr {
	public int compress(char[] chars) {
		int len = chars.length;
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		for(int i = 0; i < len; i++){
			if(map.containsKey(chars[i])){
				map.put(chars[i], map.get(chars[i]) + 1);
			}else{
				map.put(chars[i], 1);
			}
		}
		return len;
		
	}
	
	@Test
	public void test1(){
		
	}
}
