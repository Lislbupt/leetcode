package com.lisl.code;

/**
 * Merge two sorted linked lists and return it as a new list. The new list 
 * should be made by splicing together the nodes of the first two lists.
  */
public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = l1,q = l2,r = head;
		while(p!=null && q!=null){
			if(p.val<q.val){
				r.next = p;
				r = p;
				p = p.next;
			}else{
				r.next = q;
				r = q;
				q = q.next;
			}
		}
		if(p==null){
			r.next = q;
		}else{
			r.next = p;
		}
        return head.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);
		l1.next.next.next = new ListNode(7);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);
		l2.next.next.next = new ListNode(8);
		
		ListNode l = mergeTwoLists(l1, l2);
		while(l!=null){
			System.out.print(l.val);
			l = l.next;
		}
	}
}
