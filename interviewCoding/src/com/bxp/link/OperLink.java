package com.bxp.link;

public class OperLink {
	public static Node create(int[] datas){
		Node head = null;
		Node last = null;
		for(int i = 0; i < datas.length; i++){
			Node p = new Node(datas[i]);
			if(i == 0){
				head = p;
			}else{
				last.next = p;
			}
			last = p;
		}
		return head;
	}
	
	public static Node createD(int[] datas){
		Node head = null;
		Node curr = null;
		for(int i = 0; i < datas.length; i++){
			Node tem = new Node(datas[i]);
			if(head == null)
				head = tem;
			else{
				curr.next = tem;
				tem.pre = curr;
			}
			curr = tem;
		}
		return head;
	}
	public static void print(Node head){
		for(Node p = head; p != null; p = p.next){
			System.out.println(p.data + " ");
		}
	}
	
	public static void main(String[] args) {
		print(create(new int[]{1,2,3,4,5}));
	}
}
