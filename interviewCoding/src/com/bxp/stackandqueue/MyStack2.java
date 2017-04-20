package com.bxp.stackandqueue;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用两个栈实现一个队列，add，poll,peek
 * poll:弹出并返回第一个值
 * peek:获取第一个值
 * @author bxp
 */


public class MyStack2 {
	
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();

	public void add(Integer data){
		stack1.push(data);
	}
	
	public Integer poll(){
		if(stack2.empty()){
			while(!stack1.empty()){
				stack2.push(stack1.pop());
			}
		}
		if(stack2.empty())
			return null;
		return stack2.pop();
	}
	
	public Integer peek(){
		if(stack2.empty()){
			while(!stack1.empty()){
				stack2.push(stack1.pop());
			}
		}
		if(stack2.empty())
			return null;
		return stack2.peek();
	}
	
	public static void main(String[] args) {
		MyStack2 q = new MyStack2();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.peek());
	}
}
