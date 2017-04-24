package com.bxp.link;
/**
 * 打印两个链表的公共部分P34
 * @author bxp
 *
 */
public class PrintCommon {
	public static void printCommon(Node head1, Node head2){
		while(head1 != null && head2 != null){
			if(head1.data > head2.data){
				head2 = head2.next;
			}else if(head1.data < head2.data){
				head1 = head1.next;
			}else{
				System.out.println(head1.data);
				head1 = head1.next;
				head2 = head2.next;
			}
		}
	}
	public static void main(String[] args) {
		printCommon(OperLink.create(new int[]{1,2,3,4,5}),
				OperLink.create(new int[]{4,5,6,7,8}));
	}
}
