package sort;

import java.util.Arrays;

/**
 * @author leeray
 * @version 创建时间：2018年12月18日 下午6:26:55 <br>
 *          描述：274. H指数<br>
 *          给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * 
 *          h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N
 *          篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”
 */
public class H_Index {
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int level = 0;
		for (int i = 0; i < citations.length; i++) {
			level = Math.max(level, Math.min(citations[i], citations.length - i));
		}
		return level;
	}
}
