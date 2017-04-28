package com.bxp.link;

public class LisrtPartitionP53 {
	public static Node list(Node head, int pivot){
		Node left = null;
		Node hLeft = null;
		
		Node mid = null;
		Node hMid = null;
		
		Node right = null;
		Node hRight = null;
		
		for(; head != null; head = head.next){
			if(head.data < pivot){
				if (hLeft == null) {
					hLeft = head;
					left = head;
				}else{
					left.next = head;
					left = head;
				}
			}else if(head.data == pivot){
				if (hMid == null) {
					hMid = head;
					mid = head;
				}else{
					mid.next = head;
					mid = head;
				}
			}else if(head.data > pivot){
				if (hRight == null) {
					hRight = head;
					right = head;
				}else{
					right.next = head;
					right = head;
				}
			}
		}
		
		if(hLeft != null)
			left.next = hMid;
		else
			left = hMid;
		if (hMid != null) {
			mid.next = hRight;
		}else{
			if(hLeft == null)
				hLeft = hRight;
			else
				left.next = hRight;
		}
		return hLeft;
	}
	public static void main(String[] args) {
		OperLink.print(list(OperLink.create(new int[]{4,6,9,1,2,6,8,7}), 5));
	}
}
