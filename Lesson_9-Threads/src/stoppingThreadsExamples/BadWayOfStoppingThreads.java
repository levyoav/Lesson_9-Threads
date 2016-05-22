package stoppingThreadsExamples;

import threadVsRunnableExample.MyThread;

public class BadWayOfStoppingThreads {

	public static void main(String[] args) {
		//Creating a class that extends the 'Thread' class.
		MyThread t1 = new MyThread("t1");
		t1.start();

		try {
			//main sleeps for 2 seconds
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("2 seconds elapsed");
		
		//Terminating the t1 thread after waiting 2 seconds in the main thread.
		//The stop() method is deprecated. Does not allow to do a cleanup in the
		//thread.
		t1.stop();
	}

}
