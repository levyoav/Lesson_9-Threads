package synchronizationExample;

import java.util.ArrayList;
import java.util.List;

//Creates a list of integers and asserts values to that list. Then, issuing a
//run of thread 't1' of the class 'SynchronizedThread', which prints out every
//0.5 seconds the current last element of the list. In parallel to the 't1' 
//thread, the main thread removes the last element of the list after 0.1 seconds.
public class SynchronizedThreadTest {

	public static void main(String[] args) {
		System.out.println("main thread started.");
		//Creating an array list of Integers.
		List<Integer> list = new ArrayList<>();

		//Asserting values to the list.
		list.add(5);
		list.add(10);
		list.add(15);

		System.out.println(list);

		//Creating an object of the type 'SynchronizedThread' as a thread by
		//invoking its CTOR with the integers list.
		SynchronizedThread t1 = new SynchronizedThread(list);

		//Starting the thread.
		t1.start();

		//If main was asleep for 2 sec., the thread t1 would have locked list first
		//before the critical section in main would trim the last element in the list
		//and instead of printing that the last element is 10 it would print 15.
//		try {
//			Thread.sleep(200);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		//Synchronization between the 'main' thread and the 't1' thread for each
		//thread's access to the memory being referenced by 'list' using the list
		//reference as the access key to the block.
		synchronized (list) {
			System.out.println("main has locked list.");

			try {
				Thread.sleep(100); //0.1 sec delay.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//Removing the last element of the list:
			list.remove(list.size() - 1);

			//Printing the list.
			System.out.println(list);

			System.out.println("main about to release list.");
		}

		System.out.println("main has released list.");
	}

}
