package com.bxp.link;

public class DeleteNode {
	
	public static Node deleteNode(Node head, int i){
		int count = 0;
		for(Node p = head;p != null; p = p.next){
			count ++;
		}
		if(i > count){
			System.out.println("要删除的节点不存在");
		}else if(i == count){
			head = head.next;
		}else{
			i = count - i;
			count = 0;
			for(Node p = head;head != null; p = p.next){
				count ++;
				if(count == i){
					p.next = p.next.next;
					break;					
				}
			}
		}
		return head;
	}
	
	public static Node deleteDNode(Node head, int i){
		int count = 0;
		for(Node p = head;p != null; p = p.next){
			count ++;
		}
		if(i > count){
			System.out.println("要删除的节点不存在");
		}else if(i == count){
			head = head.next;
		}else{
			i = count - i;
			count = 0;
			for(Node p = head;head != null; p = p.next){
				count ++;
				if(count == i){
					if(p.next.next == null){
						p.next.pre = null;
						p.next = null;
					}else{
						p.next = p.next.next;
						p.next.pre = p;
					}
					break;			
				}
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		OperLink.print(deleteDNode(OperLink.createD(new int[]{1,2,3,4,5}), 1));
	}
}
