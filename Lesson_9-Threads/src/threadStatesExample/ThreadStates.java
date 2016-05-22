package threadStatesExample;

import threadVsRunnableExample.MyThread;

public class ThreadStates {

	public static void main(String[] args) throws InterruptedException {

		//NEW
		//Creating thread t1. No system resources have been allocated for it yet.
		//Can only be started from this state. Calling any method besides start()
		//causes 'IllegalMonitorStateException'.
		MyThread t1 = new MyThread("t1");
		//Thread t1 state is NEW after it was created.
		System.out.println(t1.getState()); //Returns the current state of this thread.

//		t1.notify(); //Throws 'IllegalMonitorStateException'.

		//RUNNABLE
		//Starting t1. Creates the system resources necessary for running the thread.
		t1.start();
		//Thread t1 state is RUNNABLE after it was started.
		System.out.println(t1.getState());

		//TIMED_WAITING
		//t1 is put to sleep (? - not so clear. main is actually put to sleep).
		Thread.sleep(10);
		//Thread t1 state is TIMED_WAITING. Can happen if the sleep(), yield(), join() thread
		//methods are invoked.
		System.out.println(t1.getState());

		//TERMINATED
		//main waits for t1 to terminate (join).
		t1.join();
		//Thread state is TERMINATED after it is done.
		System.out.println(t1.getState());

	}
}
