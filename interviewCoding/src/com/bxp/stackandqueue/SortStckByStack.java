package com.bxp.stackandqueue;

import java.util.Stack;

/**
 * 使用一个栈实现另一个栈的排序
 * @author bxp
 *
 */
public class SortStckByStack {
	public static void sortStackByStack(Stack<Integer> stack){
		Stack<Integer> help = new Stack<>();
		while(!stack.isEmpty()){
			if(help.isEmpty() || help.peek() <= stack.peek())
				help.push(stack.pop());
			else{
				int a = stack.pop();
				while(!help.isEmpty() && help.peek() > a){
					stack.push(help.pop());
				}
				help.push(a);
			}
		}
		while(!help.isEmpty()){
			stack.push(help.pop());
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(3);
		s.push(1);
		s.push(2);
		s.push(9);
		s.push(4);
		s.push(6);
		
		sortStackByStack(s);
		System.out.println("结果");
		while(!s.isEmpty()){
			System.out.print(s.pop() + "  ");
		}
	}
}
