package com.jiang.test;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author  jiangzhiyu
 * @create 2021/11/16
 */
public class ProblemOne {

	Task[] tasks;

	class Task{

		Task[] prevs;//prevConditions

		String name ;

		public Task(String name ,Task[] prevs){
			this.name = name;
			this.prevs = prevs;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Task task = (Task) o;
			return Objects.equals(name, task.name);
		}



		@Override
		public int hashCode() {
			int result = Objects.hash(name);
			return result;
		}

		public void order(LinkedList<Task> linkedList){
			if(this.prevs != null && this.prevs.length != 0){
				for (int i = 0; i < this.prevs.length; i++) {
					Task now = this.prevs[i];
					now.order(linkedList);
				}
			}
			if(!linkedList.contains(this)){
				linkedList.add(this);
			}
		}

	}

	public LinkedList<Task> order(){
		LinkedList<Task> orderList = new LinkedList<>();
		for (int i = 0; i < tasks.length; i++) {
			Task now = tasks[i];
			now.order(orderList);
		}
		return orderList;
	}

	public void mock(){
		Task h = new Task("H",null);
		Task b = new Task("B",null);
		Task[] cprev = new Task[]{h}; Task c = new Task("C",cprev);
		Task[] gprev = new Task[]{b}; Task g = new Task("G",gprev);
		Task[] eprev = new Task[]{b,g}; Task e = new Task("E",eprev);
		Task[] aprev = new Task[]{c,g}; Task a = new Task("A",aprev);
		Task[] dprev = new Task[]{a}; Task d = new Task("D",dprev);
		Task[] fprev = new Task[]{d,e}; Task f = new Task("F",fprev);
		this.tasks = new Task[]{a,b,c,d,e,f,g};
	}

	public static void main(String[] args) {
		ProblemOne dagTasks = new ProblemOne();
		dagTasks.mock();
		dagTasks.order().forEach(task -> System.out.println(task.name));
	}

}
