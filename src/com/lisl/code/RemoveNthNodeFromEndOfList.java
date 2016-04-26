package com.lisl.code;

/**
 * Given a linked list, remove the nth node from the end of list and return 
 * its head.
 */
public class RemoveNthNodeFromEndOfList {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = null,q = head,r = head;
		for(int i=0;i<n-1;i++){
			r = r.next;
		}
		while(r.next!=null){
			p = q;
			q = q.next;
			r = r.next;
		}
		if(p==null){
			return q.next;
		}
		p.next = q.next;
		q.next = null;
        return head;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		head = removeNthFromEnd(head, 5);
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
		System.out.println();
	}
}
