package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author leeray
 * @version 创建时间：2018年12月20日 下午6:22:03 <br>
 *          描述：347. 前K个高频元素<br>
 *          给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class KFrequentElement {
	public List<Integer> topKFrequent(int[] nums, int k) {
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
				new Comparator<Map.Entry<Integer, Integer>>() {

					@Override
					public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
						return o2.getValue() - o1.getValue();
					}
				});

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> res = new ArrayList<Integer>();

		for (int n : nums) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		for (Map.Entry<Integer, Integer> entry : set) {
			pq.add(entry);
		}

		for (int i = 0; i < k; i++) {
			res.add(pq.poll().getKey());
		}
		return res;
	}
}
