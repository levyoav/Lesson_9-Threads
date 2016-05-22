package waitNotifyExample;

import java.util.ArrayList;
import java.util.List;

public class Stack {

	//Setting a constant.
	public static final int MAX_CAPACITY = 5;

	//Creating a list of Integers.
	private List<Integer> list = new ArrayList<>();

	//When invoking a synchronized method, all the other synchronized methods are
	//locked and waiting to a notify from the holding method.
	public synchronized void push(Integer n) {
		//Check if the stack is full.
		while (list.size() == MAX_CAPACITY) {
			try {
				//If the stack is full, wait until a value is popped i.e, wait for 
				//a notifyAll() from the pop() method.
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//Once a value is popped and got a notifyAll() from the pop() method, add
		//a value to the stack.
		list.add(n);
		//Notify all pending threads that a value was pushed to the stack.
		notifyAll();
	}

	public synchronized int pop() {
		//Check if the stack is empty.
		while (list.size() == 0) {
			try {
				//If the stack is empty, wait until a value is pushed i.e, wait for 
				//a notifyAll() from the push() method.
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//Once a value is pushed and got a notifyAll() from the push() method, remove
		//a value to the stack.
		int n = list.remove(list.size() - 1);
		//Notify all pending threads that a value was popped from the stack.
		notifyAll();

		return n;
	}

}
