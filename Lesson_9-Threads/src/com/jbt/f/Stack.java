package com.jbt.f;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	
	//Setting a constant
	public static final int MAX_CAPACITY = 5;

	//Creating a list of integers:
	private List<Integer> list = new ArrayList<>();

	
	public synchronized void push(Integer n) {
		
		
		while (list.size() == MAX_CAPACITY) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		list.add(n);
		notifyAll();
	}

	public synchronized int pop() {

		while (list.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int n = list.remove(list.size() - 1);
		notifyAll();

		return n;
	}
}
