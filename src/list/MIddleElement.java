package list;

/**
 * @author leeray
 * @version 创建时间：2019年1月9日 下午3:51:43 <br>
 *          描述：876. 链表的中间结点<br>
 *          给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 
 *          如果有两个中间结点，则返回第二个中间结点。
 */
public class MIddleElement {
	public ListNode middleNode(ListNode head) {
		ListNode cur = head;
		int size = 1;
		while (cur.next != null) {
			size++;
			cur = cur.next;
		}
//		System.out.println(size);
		// 长度为奇数，直接返回中间唯一的一个节点即可
		if (size % 2 != 0) {
			int index1 = 0;
			ListNode op1 = head;
			while (index1 != size / 2) {
				index1++;
				op1 = op1.next;
			}
			return op1;
		} else {
			// 长度为偶数，要返回最中间的两个中的后一个
			int index2 = 0;
			ListNode op2 = head;
			while (index2 != size / 2) {
				index2++;
				op2 = op2.next;
			}
			return op2;
		}

	}
}
