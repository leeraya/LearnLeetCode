package list;

/**
 * @author leeray
 * @version 创建时间：2019年4月2日 下午7:19:45 <br>
 *          描述：148. 排序链表<br>
 *          在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 
 *          示例 1:
 * 
 *          输入: 4->2->1->3 输出: 1->2->3->4 <br>
 *          示例 2:
 * 
 *          输入: -1->5->3->4->0 输出: -1->0->3->4->5 <br>
 *          就是链表快排
 */
public class QuickSort {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = new ListNode(-1);
		newHead.next = head;// 自己添加头节点
		return quickSort(newHead, null);
	}

	ListNode quickSort(ListNode head, ListNode end) {
		if (head == null || head.next == end || head.next.next == end)
			return head;
		// 将小于划分点的节点存在临时链表中
		ListNode tempHead = new ListNode(-1);
		// patition为划分点,p为原链表指针,tp为临时链表指针
		ListNode partition = head.next, p = partition, tp = tempHead;
		// 将小于划分点的节点存入临时链表中去
		while (p.next != end) {
			if (p.next.val < partition.val) {
				tp.next = p.next;// 存入临时链表
				tp = tp.next;// 临时链表指针后移
				p.next = p.next.next;// 原链表收缩
			} else {
				p = p.next;
			}
		}
		// 合并临时链表和原链表
		tp.next = head.next;
		// 插回原链表
		head.next = tempHead.next;
		// 递归
		quickSort(head, partition);
		quickSort(partition, end);
		return head.next;// 题目要求不带头节点
	}
}
