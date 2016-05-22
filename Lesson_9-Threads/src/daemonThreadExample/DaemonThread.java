package daemonThreadExample;

import threadVsRunnableExample.MyThread;

public class DaemonThread {

	public static void main(String[] args) {
		//A thread that counts from 1 to 10 every 0.5 sec. and then terminates.
		MyThread t1 = new MyThread("t1");

		//Setting the thread to be a DAEMON thread. That means that the thread
		//will terminate once main ends, regardless if its run() method is done.
		//So if t1 is set to be a Daemon thread like so, it should count to 4
		//and then terminate along with main. If it is not set to be Daemon, it
		//will count to 10 and then terminate even if main has already ended.
		t1.setDaemon(true);

		//Launching the thread.
		t1.start();

		//Delaying main for 2 sec.
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Printing at the end of main. 
		System.out.println("main ended");
	}
}
