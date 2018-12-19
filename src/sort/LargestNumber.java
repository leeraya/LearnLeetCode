package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2018年12月18日 下午6:44:30 <br>
 *          描述：179. 最大数<br>
 *          给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
		String res = "";
		if(nums == null || nums.length == 0)
			return res;
		
		int Zero = 0;
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0)
				Zero++;
			list.add(String.valueOf(nums[i]));
		}
		//如果全是0，则返回0
		if(Zero == nums.length)
			return "0";
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return s2.compareTo(s1);
			}
		});
		
		for(int i = 0; i < list.size(); ++i){
			res+=list.get(i);
		}
		return res;
	}
}
