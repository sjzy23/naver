package com.jiang.test;

/**
 * array implements queue , include push, pop, peek, empty methods.
 * @author  jiangzhiyu
 * @create 2021/11/16
 */
public class ProblemThree  {

	private  int capacity;

	private Object[] elements;

	private int head = 0;

	private int tail = 0;

	private int size = 0;

	public ProblemThree(){
		capacity = 16;
		size = 0;
		tail = 0;
		head = 0;
		elements = new Object[16];
	}

	public ProblemThree(int capacity){
		if(capacity <= 0){
			throw new IllegalArgumentException();
		}
		this.capacity = capacity;
		size = 0;
		tail = 0;
		head = 0;
		elements = new Object[this.capacity];
	}

	public synchronized boolean push(Object o){
		if(isFull()){
			return false;
		}
		elements[head] = o;
		head = addOne(head);
		size ++;
		return true;
	}

	public synchronized Object pop(){
		Object result = null;
		if(isEmpty()){
			return result;
		}
		result = elements[tail];
		tail = addOne(tail);
		size --;
		return result;
	}

	public synchronized Object peek(){
		Object result = null;
		if(isEmpty()){
			return result;
		}
		result = elements[tail];
		return result;
	}

	public synchronized void empty(){
		elements = new Object[this.capacity];
		size = 0;
		tail = 0;
		head = 0;
	}

	public synchronized int getSize(){
		return size;
	}


	public synchronized boolean isEmpty(){
		return size == 0;
	}
	public synchronized boolean isFull(){
		return size == capacity;
	}

	//index add one step
	private synchronized int addOne(int index){
		return index + 1 == capacity? 0: index +1;
	}


	public static void main(String[] args) {
		ProblemThree queue = new ProblemThree(4);
		System.out.println("queue.push(1) : " + queue.push(1));
		System.out.println("queue.push(2) : " + queue.push(2));
		System.out.println("queue.push(3) : " + queue.push(3));
		System.out.println("queue.push(4) : " + queue.push(4));
		System.out.println("queue.push(5) : " + queue.push(5));
		System.out.println("queue.pop() : " + queue.pop());
		System.out.println("queue.pop() : " + queue.pop());
		System.out.println("queue.peek() : " + queue.peek());
		System.out.println("queue.pop() : " + queue.pop());
		System.out.println("queue.pop() : " + queue.pop());
		System.out.println("queue.pop() : " + queue.pop());
		System.out.println("queue.peek() : " + queue.peek());
		System.out.println("queue.push(10) : " + queue.push(10));
		System.out.println("queue.push(20) : " + queue.push(20));
		System.out.println("queue.push(30) : " + queue.push(30));
		System.out.println("queue.push(40) : " + queue.push(40));
		System.out.println("queue.pop() : " + queue.pop());
		queue.empty();
		System.out.println("queue.pop() after empty() : " + queue.pop());
	}

}
