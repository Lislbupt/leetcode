package com.lisl.code;

public class AddTwoNumber {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode res = new ListNode(0);
		ListNode p = res;
		int over = 0;
		while(p1!=null && p2!=null){
			int sum = p1.val+p2.val+over;
			int v = sum;
			if(sum>9){
				v = sum%10;
				over = sum/10;
			}else{
				over = 0;
			}
			ListNode temp = new ListNode(v);
			p.next = temp;
			p = temp;
			p1 = p1.next;
			p2 = p2.next;
		}
		while(p1!=null){
			if(over==0){
				p.next = p1;
				break;
			}
			int sum = p1.val+over;
			int v = sum;
			if(sum>9){
				v = sum%10;
				over = sum/10;
			}else{
				over = 0;
			}
			ListNode temp = new ListNode(v);
			p.next = temp;
			p = temp;
			p1 = p1.next;
		}
		while(p2!=null){
			if(over==0){
				p.next = p2;
				break;
			}
			int sum = p2.val+over;
			int v = sum;
			if(sum>9){
				v = sum%10;
				over = sum/10;
			}else{
				over = 0;
			}
			ListNode temp = new ListNode(v);
			p.next = temp;
			p = temp;
			p2 = p2.next;
		}
		if(over!=0){
			p.next = new ListNode(over);
		}
        return res.next;
    }
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
//		a.next = new ListNode(4);
//		a.next.next = new ListNode(3);
//		a.next.next.next = new ListNode(8);
		
		ListNode b = new ListNode(9);
		b.next = new ListNode(9);
//		b.next.next = new ListNode(9);
		
		ListNode res = addTwoNumbers(a, b);
		ListNode p = res;
		while(p!=null){
			System.out.println(p.val);
			p = p.next;
		}
	}
}
