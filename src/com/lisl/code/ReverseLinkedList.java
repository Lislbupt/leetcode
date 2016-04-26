package com.lisl.code;

/**
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
	public static ListNode reverseList1(ListNode head) {
		ListNode p=head,q,r=null;
		
		while(p!=null){
			q = p.next;
			p.next = r;
			if(q==null){
				return p;
			}
			r = p;
			p = q;
		}
        return null;
    }
	
	public static ListNode reverseList2(ListNode head){
		if(head==null){
			return null;
		}
		ListNode p=head,q = p.next,r;
		while(q!=null){
			r = q.next;
			q.next = p;
			p = q;
			q = r;
		}
		head.next = null;
		return p;
	}
	
	public static void main(String[] args) {
		ListNode list = new ListNode(5);
		list.next = new ListNode(9);
		list.next.next = new ListNode(1);
		list.next.next.next = new ListNode(2);
		list.next.next.next.next = new ListNode(6);
//		ListNode n = reverseList1(list);
		ListNode n = reverseList2(list);
		while(n!=null){
			System.out.print(n.val+" ");
			n = n.next;
		}
	}
}
