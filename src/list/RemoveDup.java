package list;

import org.junit.Test;

/**
 * @author leeray
 * @version 创建时间：2019年1月8日 下午3:40:56 <br>
 *          描述：83. 删除排序链表中的重复元素<br>
 *          给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class RemoveDup {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		if (cur == null)
			return head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}
	
	@Test
	public void test1(){
		ListNode head = new ListNode(1);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		head.next = one;
		one.next = two;
		head = deleteDuplicates(head);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
