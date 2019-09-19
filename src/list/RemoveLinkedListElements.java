package list;

/**
 * @author leeray
 * @version 1.0
 * @date 2019/9/19 0019 18:22
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
    /*
    执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     */
    public ListNode removeElements(ListNode head, int val) {
        //前两步非常关键，可以解决头节点命中的问题
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode curr = header;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return header.next;
    }
}
