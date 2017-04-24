package com.bxp.stackandqueue;

import java.util.LinkedList;

/**
 * 生成最大窗口（P19）
 * @author bxp
 *
 */
public class MaxWindow {
	public int[] getMaxWindow(int[] arr, int w){
		//创建双端队列
		LinkedList<Integer> qu = new LinkedList<>();
		int index = 0;
		int[] win = new int[arr.length - w + 1];
		for(int i = 0; i < arr.length; i++){
			if(qu.isEmpty()){
				qu.add(i);
				continue;
			}
			while(!qu.isEmpty() && arr[i] >= arr[qu.peekLast()]){
				qu.pollLast();
			}
			qu.addLast(i);
			if(i == qu.peekFirst() + w)
				qu.pollFirst();
			if(i >= w - 1){
				win[index] = arr[qu.peekFirst()];
				index ++;
			}
		}
		return win;
	}
	
	public static void main(String[] args) {
		int[] arr = new MaxWindow().getMaxWindow(new int[]{4,3,5,4,3,3,6,7}, 3);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i] + "  " );
		}
	}
}
