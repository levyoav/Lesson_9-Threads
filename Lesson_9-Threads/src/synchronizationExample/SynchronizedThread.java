package synchronizationExample;

import java.util.List;

//A thread that receives a list of integers to it's CTOR, and after half a
//second, prints the current last element in the list.
public class SynchronizedThread extends Thread {

	//A list of integers as an attribute of the thread.
	private List<Integer> list;

	//CTOR that receives the integer list as a parameter.
	public SynchronizedThread(List<Integer> list) {
		super();
		this.list = list;
	}

	//Overriding the run() method of the 'Thread' class for defining the thread's
	//functionality.
	public void run() {
		System.out.println(getName() + " thread started.");
		//Synchronization between 2 or more parallel threads for the access of each 
		//thread to the memory space being referenced by 'list'. This is actually
		//a CRITICAL SECTION with the reference to the list as the KEY. The list is
		//released for access to other threads if this thread passes the end of the 
		//synchronized block or automatically released if there is a break or an 
		//exception is thrown in the block. 
		synchronized (list) {
			System.out.println(getName() + " has locked list.");

			//Getting the list's length.
			int lastIndex = list.size() - 1;

			try {
				Thread.sleep(500); //Delay for 0.5 sec.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//Printing the last element in the list.
			System.out.print("last element is: ");
			System.out.println(list.get(lastIndex));

			System.out.println(getName() + " about to release list.");
		}

		//The list is released here.
		System.out.println(getName() + " has released list.");

	}

}
