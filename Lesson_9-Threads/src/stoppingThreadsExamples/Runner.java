package stoppingThreadsExamples;

//Demonstrates how to properly stop a thread.
public class Runner implements Runnable {

	//Defining a boolean to designate when to stop the thread.
	private boolean timeToQuite;


	@Override
	public void run() {
		//While boolean is true, run.
		while(!timeToQuite) {
			System.out.println("Still running");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//Cleanup to be done for when the thread stops.
		System.out.println("doing cleanup");
		System.out.println("stop");
	}

	//Method for stopping the thread by asserting the boolean accordingly. Will
	//not stop the thread immediately. Only in the following iteration of the
	//'while' loop in the run() method and after all the cleanup operations are done. 
	public void stopRunning() {
		timeToQuite = true;
	}
}
