package threadVsRunnableExample;

//Creating a thread as a class that IMPLEMENTS the interface 'Runnable'.
//Advantage: Not using up the only extendible of the class. Free to extend other classes.
//Disadvantage: Indirect access to the Thread class methods. More coding.
public class MyRunnable implements Runnable {

	@Override
	//Overriding the 'Runnable' run() method for creating the thread's MyRunnable 
	//functionality. 
	public void run() {
		for (int i = 1; i <=10; i++) {
			//getName() for getting the name of the current thread. Need to use 
			//the fully qualified method access path because 'MyRunnable' does'nt
			//extend the 'Thread' class.
			System.out.println(i + " - " + Thread.currentThread().getName());
			try {
				//Static method for putting the current thread to sleep in mSec.
				//Throws 'InterruptedException'.
				Thread.sleep(750);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
