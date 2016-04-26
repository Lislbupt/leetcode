package com.lisl.code;

import java.util.ArrayList;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and 
 * return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the 
 * end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {
	public static ListNode reverseKGroup1(ListNode head, int k) {
		if(k==1){
			return head;
		}
		ListNode p = head,res = new ListNode(0),rear = res;
		while(p!=null){
			ArrayList<ListNode> temp = new ArrayList<ListNode>();
			temp.add(p);
			ListNode q = p.next;
			for(int i=1;i<k;i++){
				if(q!=null){
					temp.add(q);
					q = q.next;
				}
			}
			p = q;
			if(temp.size()<k){
				for(ListNode node : temp){
					rear.next = node;
					rear =  node;
				}
			}else{
				for(int i=k-1;i>=0;i--){
					ListNode node = temp.get(i);
					rear.next = node;
					rear = node;
				}
			}
		}
		rear.next = null;
        return res.next;
    }
	
	public static ListNode reverseList(ListNode head) {
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
	
	public static ListNode reverseKGroup2(ListNode head, int k){
		if(k==1){
			return head;
		}
		ListNode res = new ListNode(0),rear = res,p = head,q,r,part_head;
		while(p!=null){
			part_head = p;
			q = p.next;
			boolean flag = true;
			for(int i=0;i<k-1;i++){
				if(q!=null){
					r = q.next;
					q.next = p;
					p = q;
					q = r;
				}else{
					flag = false;
					part_head.next = null;
				}
			}
			if(flag){
				rear.next = p;
				rear = part_head;
				p = q;
			}else{
				rear.next = reverseList(p);
				return res.next;
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
		
//		ListNode res = reverseKGroup1(head,6);
		ListNode res = reverseKGroup2(head,5);
		while(res!=null){
			System.out.print(res.val+" ");
			res = res.next;
		}
	}
}
