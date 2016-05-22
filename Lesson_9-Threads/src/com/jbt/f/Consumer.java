package com.jbt.f;

public class Consumer extends Thread {

	private Stack stack;

	public Consumer(Stack stack, String name) {
		super(name);
		this.stack = stack;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			int n = stack.pop();
			System.out.println("consumer " + getName() + " popped: " + n);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
