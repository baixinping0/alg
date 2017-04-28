package com.bxp.link;

import java.util.Stack;

public class IsPalindromeP48 {
	
	public static boolean isP1(Node head){
		Stack<Node> s = new Stack<>();
		for(Node p = head; p != null; p = p.next){
			s.push(p);
		}
		for(Node p = head; p != null; p = p.next){
			if(p.data != s.pop().data)
				return false;
		}
		return true;
	}
	
	
	
	public static boolean isP2(Node head){
		Node h = head;
		if(head == null || head.next == null)
			return true;
		//循环结束后p最终指向左边链表的最后一个节点,中间节点
		Node p = null;
		//循环结束后q最终指向倒数第一个节点或者倒数第二个节点
		Node q = null;
		for( p = head, q = head; q.next != null && q.next.next != null; p = p.next, q = q.next.next){
			
		}
		//获取右半部分
		Node right = p.next;
		//对右半部分进行翻转操作
		Node pre = null;
		Node next = null;
		q = right;
		while(q != null){
			next = q.next;
			q.next = pre;
			pre = q;
			q = next;
		}
		
		//保存右半部分最后一个节点
		right = pre;
		boolean res = true;
		while(pre != null && head != null){
			if(pre.data != head.data){
				res = false;
				break;
			}
			pre = pre.next;
			head = head.next;
		}
		//将链表恢复原样
		
		pre = null;
		next = null;
		while(right != null){
			next = right.next;
			right.next = pre;
			pre = right;
			right = next;
		}
		//验证还原结果
		OperLink.print(h);
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(isP2(OperLink.create(new int[]{2,1,2})));
	}
	
	
	
	
	
}
