package com.lisl.code;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and 
 * describe its complexity.
 */
public class MergeKSortedLists {
	//合并两个有序链表
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
	//将k个链表平均分为两份，递归的合并两份链表
	public static ListNode sort(ListNode[] lists,int low,int high){
		if(low<high){
			int mid = low + (high-low)/2;
			ListNode l1 = sort(lists,low,mid);
			ListNode l2 = sort(lists,mid+1,high);
			return mergeTwoLists(l1, l2);
		}else{
			return lists[low];
		}
	}
	
	public static ListNode mergeKLists1(ListNode[] lists) {
		int len = lists.length;
		if(lists==null || len==0){
			return null;
		}
		return sort(lists, 0, len-1);
    }
	
	public static ListNode mergeKLists2(ListNode[] lists) {
		int len = lists.length;
		ListNode head = new ListNode(0),r = head;
		if(lists==null || len==0){
			return null;
		}
		//利用优先队列动态排序，找出值最小的节点
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(len,new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
			
		});
		for(ListNode node : lists){
			if(node!=null){
				queue.offer(node);
			}
		}
		while(!queue.isEmpty()){
			ListNode first = queue.poll();
			r.next = first;
			r = first;
			ListNode next = first.next;
			if(next!=null){
				queue.offer(next);
			}
		}
		return head.next;
    }

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode nodes[] = new ListNode[2];
		nodes[0] = l1;
		nodes[1] = l2;
		mergeKLists2(nodes);
	}
}
