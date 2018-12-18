package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2018年12月18日 下午4:20:36 <br>
 *          描述：57. 插入区间<br>
 *          给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 *          在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。<br>
 *          示例 2:
 * 
 *          输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval =
 *          [4,8] 输出: [[1,2],[3,10],[12,16]] <br>
 *          解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
/*
 * class Interval { int start; int end;
 * 
 * Interval() { start = 0; end = 0; }
 * 
 * Interval(int s, int e) { start = s; end = e; } }
 */
public class InsertIntervals {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if ((intervals == null || intervals.size() == 0) && (newInterval == null))
			return intervals;
		// 返回结果的列表
		List<Interval> res = new ArrayList<Interval>();

		// intervals为空，直接插入
		if ((intervals == null || intervals.size() == 0) && newInterval != null) {
			res.add(newInterval);
			return res;
		}
		intervals.add(newInterval);
		// 对intervals进行排序，按照start小的排前面的策略
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		res.add(intervals.get(0));
		int len = res.size();
		for (int i = 1; i < intervals.size(); i++) {
			if (res.get(len - 1).end >= intervals.get(i).start) {
				res.set(len - 1,
						new Interval(res.get(len - 1).start, Math.max(intervals.get(i).end, res.get(len - 1).end)));
			} else {
				res.add(intervals.get(i));
				len++;
			}
		}
		return res;
	}
}
