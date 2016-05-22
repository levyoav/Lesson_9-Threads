package com.jbt.f;

public class Producer extends Thread {

	private Stack stack;

	public Producer(Stack stack, String name) {
		super(name);
		this.stack = stack;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			int r = (int) (Math.random()*26);
			stack.push(r);
			System.out.println("producer " + getName() + " pushed: " + r);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
