package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author leeray
 * @version 创建时间：2018年12月30日 下午4:43:08 <br>
 * 			描述：599. 两个列表的最小索引总和<br>
 *          假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 
 *          你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 */
public class IndexSum {
	public String[] findRestaurant(String[] list1, String[] list2) {
        //思路：
        //先将第一个列表用list装入，然后遍历第二个列表。
        //在遍历的过程中，记录二者相同喜欢的餐厅的下标和，每次遍历要看下标和是不是最小，如果一样小就加入返回数组中。
        List<String> strs = new ArrayList<String>();
        Map<String , Integer> map = new HashMap<String , Integer>();
        for(int i = 0; i < list1.length; i++){
            strs.add(list1[i]);
        }
        int temp = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++){
            if(strs.contains(list2[i])){
                map.put(list2[i] , i + strs.indexOf(list2[i]));
                //找最下索引和
                temp = Math.min(temp, map.get(list2[i]));
            }
           
        }
        
        strs.clear();//充分利用
        for(Map.Entry<String , Integer> en : map.entrySet()){
        	if(en.getValue() == temp){
        		strs.add(en.getKey());
        	}
        }
        
        String [] res = new String[strs.size()];
        for(int i = 0; i < strs.size(); i++){
        	res[i] = strs.get(i);
        }
        return res;
    }
	
	@Test
	public void test1(){
		String [] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
		String [] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
		String [] res = findRestaurant(list1, list2);
		for(String s : res){
			System.out.println(s);
		}
	}
}
