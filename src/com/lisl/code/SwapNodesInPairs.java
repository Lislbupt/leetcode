package com.lisl.code;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {
	public static ListNode swapPairs(ListNode head) {
		ListNode p = head,q,r,res = new ListNode(0),rear = res;
		while(p!=null){
			q = p.next;
			if(q!=null){
				rear.next = q;
				r = q.next;
				q.next = p;
				rear = p;
				p = r;
			}else{
				rear.next = p;
				rear = p;
				break;
			}
		}
		rear.next = null;
        return res.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		
		ListNode res = swapPairs(head);
		while(res!=null){
			System.out.print(res.val+" ");
			res = res.next;
		}
	}
}
