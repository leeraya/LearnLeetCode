package list;

/**
 * @author leeray
 * @version 创建时间：2019年1月9日 下午3:54:39 <br>
 *          描述：237. 删除链表中的节点<br>
 *          请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 
 *          现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * 
 *          4 -> 5 -> 1 -> 9<br>
 *          链表至少包含两个节点。 链表中所有节点的值都是唯一的。<br>
 *          给定的节点为非末尾节点并且一定是链表中的一个有效节点。<br>
 *          不要从你的函数中返回任何结果。
 */
public class DeleteNode {
	public void deleteNode(ListNode node) {
		//node是链表中的一个节点，我们要删除它
		//最直接的方法是将node的后一个节点复制过来即可
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
