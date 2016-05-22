package threadVsRunnableExample;

public class Test {

	public static void main(String[] args) {

		//1. Creating a thread using the class Thread:
		
		//Instantiating a thread from a class that extends the class Thread. Using
		//the CTOR with the String parameter for naming the thread t1.
		MyThread t1 = new MyThread("t1");
		//Starting the thread t1.
		t1.start();

		//2. Creating a thread using the interface Runnable:
		
		//Instantiating a runnable from a class that implements the interface Runnable.
		MyRunnable r = new MyRunnable();

		//Instantiating a thread from the class Thread by using the CTOR that receives
		//as parameters the Runnable object 'r' and a String for naming the runnable 
		//object as a Thread.
		Thread t2 = new Thread(r, "t2");
		Thread t3 = new Thread(r, "t3");

		//Starting the threads t2 and t3.
		t2.start();
		t3.start();

		//Rest of main. Main ends before threads t1, t2 and t3 end. Even after main
		//ends, they keep running until they are done.
		for (int i = 1; i <= 10; i++) {
			//getName() for getting the name of the current thread. Need to use 
			//the fully qualified method access path because main does'nt
			//extend the 'Thread' class.
			System.out.println(i + " - " + Thread.currentThread().getName());

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("main ended");
	}
}
