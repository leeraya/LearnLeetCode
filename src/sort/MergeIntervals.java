package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2018年12月18日 下午3:37:59 <br>
 *          描述：56. 合并区间<br>
 *          给出一个区间的集合，请合并所有重叠的区间。<br>
 *          给出一个区间的集合，请合并所有重叠的区间。
 * 
 *          示例 1:
 * 
 *          输入: [[1,3],[2,6],[8,10],[15,18]] 输出: [[1,6],[8,10],[15,18]] <br>
 *          解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0)
			return intervals;
		
		//按照区间的start大小进行升序排列
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		
		List<Interval> res = new ArrayList<Interval>();
		//先将排好的第一个元素放入res中，然后从第二个遍历intervals。
		res.add(intervals.get(0));
		int len = res.size();
		//遍历的主要目的，是看interval中的元素是否有相交的，如果有相交的，就将该相交的区间的end付给res中的被交元素。
		//如果没有相交，就将该元素放入res中
		for(int i = 1; i < intervals.size(); i++){
			//两个区间有重合或者刚好粘连在一起，则将其合并
			if(intervals.get(i).start <= res.get(len - 1).end){
				//注意这里max(),防止是包含的情况如{[1,4],[2,3]}结果是[1,4] 而不是[1,3]
				res.set(len - 1, new Interval(res.get(len-1).start , Math.max(intervals.get(i).end,res.get(len-1).end)));
			}else{
				res.add(intervals.get(i));
				len++;
			}
		}
		return res;
	}
}
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}