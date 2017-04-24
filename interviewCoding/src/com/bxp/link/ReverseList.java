package com.bxp.link;

public class ReverseList {
	public static Node reverseList(Node head){
		Node pre = null;
		Node next = null;
		while(head != null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public static Node reverseListD(Node head){
		Node pre = null;
		Node next = null;
		while(head != null){
			next = head.next;
			head.next = pre;
			head.pre = next;
			pre = head;
			head = next;
		}
		return pre;
	}
	public static Node reverseListPart(Node head, int from, int to){
		Node pre = null;
		Node last = null;
		
		Node part = null;
		Node end = null;
		int count = 0;
		for(Node p = head; p != null; p = p.next){
			count ++;
			if(count == from - 1){
				pre = p;
				part = pre.next;
			}
			if(count == to){
				end = p;
				last = p.next;
			}
		}
		end.next = null;
		//这种情况说明整个反转
		if(part == null && last == null)
			return reverseList(head);
		//如果第一个需要反转,最后一个节点不需要反转，此时part和pre为null
		if(part == null){
			part = head;
			reverseList(head);
			part.next = last;
			return end;
			
			//第一个不需要反转，最后一个需要反转
		}else if(last == null){
			pre.next = reverseList(part);
			return head;
			
			//反转的为中间部分
		}else{
			reverseList(part);
			pre.next = end;
			part.next = last;
			return head;
		}
	}
	public static void main(String[] args) {
		OperLink.print(reverseListPart(OperLink.create(new int[]{1,2,3,4,5}), 2,5));
	}
}
