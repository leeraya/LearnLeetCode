package list;

/**
 * @author leeray
 * @version 创建时间：2019年1月14日 下午1:53:34 <br>
 *          描述：19. 删除链表的倒数第N个节点<br>
 *          给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class RemoveNTHNode {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		//双指针法，先让一个指针先走n步，然后让两个指针同步走
		//前指针指向尾部时，后指针的下一个节点就是要删除的节点
		ListNode left = head, right = head;
		for (int i = 0; i < n; i++) {
			right = right.next;
		}
		if (right == null) {
			head = head.next;
			return head;
		}
		while (right.next != null) {
			left = left.next;
			right = right.next;
		}
		left.next = left.next.next;
		return head;
		
	}
}
