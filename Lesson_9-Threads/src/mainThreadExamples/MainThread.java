package mainThreadExamples;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {

		//Get a reference to the current thread (main).
		Thread mainThread = Thread.currentThread();

		//Returns the thread’s name. If invoked within a class that is a running
		//thread, such as main, using: Thread.currenThread().getNmae(),
		//it returns ‘main’.
		System.out.println(mainThread.getName()); //'main' is printed.

		//1-10 is printed every 0.25 sec.
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);

			//Causes the currently executed thread to cease execution for the
			//specified number of mili-seconds. Throws 'InterruptedException'.
			Thread.sleep(250);
		}
	}

}
