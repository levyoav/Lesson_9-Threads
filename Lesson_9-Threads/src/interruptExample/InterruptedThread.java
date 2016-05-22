package interruptExample;

//A Thread class that counts up in a 'for' loop, and in each iteatrion
//it checks if this thread was interrupted.
public class InterruptedThread extends Thread {

	public InterruptedThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		//Counts up.
		for (int i = 1; i <= 100000; i++) {
			System.out.println(i + " - " + getName());

			//Checks if the thread was interrupted. Returns true if the thread
			//was interrupted, false otherwise. If this method returns true and 
			//would have been called again, it would return false, unless the
			//thread would have been interrupted again since the first call of 
			//this method.
			if (Thread.interrupted()) {
				System.out.println(getName() + " thread was interrupted");
				break;
			}

			//If the thread is interrupted while is is waiting an 'InterruptedException'
			//is  thrown.
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// write what to do if thread is interrupted
//				System.out.println(getName() + " thread was interrupted");
//				e.printStackTrace();
//				break;
//			}
		}

	}
}
