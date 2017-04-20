package com.bxp.stackandqueue;

import java.util.Stack;

/**
 * 设计一个栈，再实现栈的基础上完成返回栈中最小元素的操作。
 * 
 * 要求：pop，push，geMin操作的时间复杂度都是O(1)
 * @author bxp
 *
 */
public class MyStack1 {
	private Stack<Integer> stackData = new Stack<>();
	private Stack<Integer> stackMin = new Stack<>();
	
	public Integer pop(){
		Integer data = stackData.pop();
		if(data <= stackMin.peek())
			stackMin.pop();
		return data;
	}
	
	public void push(Integer data){
		stackData.push(data);
		if(stackMin.empty() || data <= stackMin.peek()){
			stackMin.push(data);
		}
	}
	
	public Integer getMin() throws Exception{
		if(stackMin.empty())
			return null;
		else
			return stackMin.peek();
	}
	
	public static void main(String[] args) throws Exception {
		MyStack1 s = new MyStack1();
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(1);
		s.push(2);
		s.push(1);
		
		s.pop();s.pop();s.pop();s.pop();s.pop();s.pop();
		
		System.out.println(s.getMin());
	}
	
}
