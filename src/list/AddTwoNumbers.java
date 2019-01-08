package list;

import org.junit.Test;

/*
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
   你可以假设除了数字 0 之外，这两个数字都不会以零开头。
   示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
*/
public class AddTwoNumbers {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode c1 = l1;
	        ListNode c2 = l2;      //获取传入的参数l1,l2，交由c1,c2来操作
	        ListNode sentinel = new ListNode(0);    //作为最后输出的List
	        ListNode dummy = sentinel;//对头结点进行操作时，考虑创建哑节点dummy，使用dummy->next表示真正的头节点
	        int sum = 0;           //两链表对应位置的和，十进制，满10要进一
	        while (c1 != null || c2 != null) { //两个相加的链表只要有一个不为空，即可满足条件
	        	sum /= 10; 	      //这行代码必须放在以下两个if判断以上，这行代码的作用是清空之前相加的值，并且保存进位。
	            if (c1 != null) {
	                sum += c1.val;
	                c1 = c1.next;
	            }
	            if (c2 != null) {
	                sum += c2.val;
	                c2 = c2.next;
	            }
	            dummy.next = new ListNode(sum % 10);
	            dummy = dummy.next;
	        }
	        if (sum / 10 == 1)
	        	dummy.next = new ListNode(1); 
	        return sentinel.next;
	    }
	 
	 //测试
	 @Test
	 public void test1(){
		 ListNode l1 = new ListNode(2);
		 ListNode l1a = new ListNode(4);
		 ListNode l1b = new ListNode(3);
		 l1.next=l1a;
		 l1.next.next=l1b;
		 
		 ListNode l2 = new ListNode(5);
		 ListNode l2a = new ListNode(6);
		 ListNode l2b = new ListNode(4);
		 l2.next = l2a;
		 l2.next.next = l2b;
		 
		 ListNode dummy = addTwoNumbers(l1, l2);
		 System.out.println(dummy.val);
		 dummy = dummy.next;
		 System.out.println(dummy.val);
		 dummy=dummy.next;
		 System.out.println(dummy.val);
	 }
}
