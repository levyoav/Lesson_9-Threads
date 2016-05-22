package threadVsRunnableExample;

//Creating a thread as a class that EXTENDS the 'Thread' class.
//Advantage: Easy access to the Thread class methods. Less coding.
//Disadvantage: Using the only extendible for the class. Cannot extend any other class.
public class MyThread extends Thread {

	//Creating a CTOR with a String type parameter for assigning a name to the 
	//Thread object, by invoking the 'Thread' class CTOR with the same signature.
	public MyThread(String name) {
		super(name);
	}

	//Overriding the 'Thread' run() method (which is empty) for creating the 
	//thread's MyThread functionality.  
	@Override
	public void run() {

		for (int i = 1; i <=10; i++) {
			//getName() for getting the name of the current thread. It is a method
			//in the class Thread.
			System.out.println(i + " - " + super.getName());

			try {
				//Static method for putting the current thread to sleep in mSec.
				//Throws 'InterruptedException'.
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
