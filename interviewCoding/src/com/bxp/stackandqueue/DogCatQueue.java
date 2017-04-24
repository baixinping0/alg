package com.bxp.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 * 
 * 
 * 实现： 调用add方法将cat或者dog加入队列 调用pollAll将队列中的数据按照进队列的顺序出队列 调用pollDog将dog全部弹出
 * 调用pollCat将cat全部弹出 调用isEmpty判断是否还有cat或者Dog isDogEmpty isCatEmpty
 * 
 * @author bxp
 *
 */
public class DogCatQueue {

	/**
	 * 思路： 自定义新的类，子段为Pet和进队列的时间戳
	 */
	Queue<MyPet> dogQ = new LinkedList<>();
	Queue<MyPet> catQ = new LinkedList<>();
	
	public void add(Pet pet){
		if(Pet.TYPE_CAT.equals(pet.getType())){
			catQ.add(new MyPet(pet, System.currentTimeMillis()));
		}else if(Pet.TYPE_DOG.equals(pet.getType())){
			dogQ.add(new MyPet(pet, System.currentTimeMillis()));
		}
	}
	
	public Pet pollAll(){
		if(catQ.peek().getTime() > dogQ.peek().getTime()){
			return catQ.poll().getPet();
		}else{
			return dogQ.poll().getPet();
		}
	}
	
	public Dog pollDog(){
		return (Dog) dogQ.poll().getPet();
	}
	
	public Cat pollCat(){
		return (Cat) catQ.poll().getPet();
	}
	
	public boolean isEmpty(){
		if(catQ.isEmpty() && dogQ.isEmpty())
			return true;
		else
			return false;
	}
	
	public boolean isDogEmpty(){
		return dogQ.isEmpty();
	}
	
	public boolean isCatEmpty(){
		return catQ.isEmpty();
	}
	
	class MyPet {
		private Pet pet;
		private Long time;
		public MyPet(Pet pet, Long time) {
			super();
			this.pet = pet;
			this.time = time;
		}
		public Pet getPet() {
			return pet;
		}
		public void setPet(Pet pet) {
			this.pet = pet;
		}
		public Long getTime() {
			return time;
		}
		public void setTime(Long time) {
			this.time = time;
		}
	}

}

class Pet {
	public static final String TYPE_CAT = "cat";
	public static final String TYPE_DOG = "dog";
	private String type;

	public Pet(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}

class Cat extends Pet {
	public Cat() {
		super(Pet.TYPE_CAT);
	}
}

class Dog extends Pet {
	public Dog() {
		super(Pet.TYPE_DOG);
	}
}