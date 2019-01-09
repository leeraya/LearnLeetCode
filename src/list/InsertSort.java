package list;

/**
 * @author leeray
 * @version 创建时间：2019年1月9日 下午4:19:51 <br>
 *          描述：147. 对链表进行插入排序<br>
 *          对链表进行插入排序。
 */
public class InsertSort {
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return head;
		// 创建哑节点dummy
		ListNode dummy = new ListNode(0);
		// 创建排序好的序列的哑节点pre, 未排序好的头节点next
		ListNode pre = dummy;
		ListNode next;
		// 当前节点cur
		ListNode cur = head;
		while (cur != null) {
			next = cur.next;
			// 当前元素为cur,要在排好的序列中找打插入的位置
			while (pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			// 插入操作，现在pre指向了cur可以插入的位置
			// 先要将pre后的节点连接到cur上，然后将cur连接到pre后面
			cur.next = pre.next;
			pre.next = cur;
			pre = dummy;// 重新回到头部的哑节点

			// 元素后移
			cur = next;
		}
		return dummy.next;
	}
}
