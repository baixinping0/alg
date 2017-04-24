package com.bxp.stackandqueue;

import java.util.Stack;

import javax.sound.sampled.ReverbType;

/**
 * 使用递归操作和栈操作逆序一个栈，不能使用其他数据结构
 * @author bxp
 *
 */
public class MyStack3 {
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		for(int i = 0; i < 10; i++){
			s.push(i);
		}
		new MyStack3().reverse(s);
		while(!s.empty()){
			System.out.print(s.pop() + " ");
		}
	}
	
	public void reverse(Stack<Integer> stack){
		if(stack.empty())
			return;
		int last = getLastAndPop(stack);
		reverse(stack);
		stack.push(last);
		
	}
	
	/**
	 *获取最底层的元素并删除
	 * @param stack
	 * @return
	 */
	public int getLastAndPop(Stack<Integer> stack){
		int res = stack.pop();
		if(!stack.empty()){
			int last = getLastAndPop(stack);
			stack.push(res);
			return last;
		}
		return res;
	}
}





