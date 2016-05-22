package stoppingThreadsExamples;

public class RunnerControllerTest {

	public static void main(String[] args) {

		//Creating a RunnerController object that has a thread object as one of 
		//its attributes.
		RunnerController rc = new RunnerController();

		//Invoking the methods which starts the thread.
		rc.startThread();

		//5 seconds delay within 'main'.
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Invoking the method which stops the thread.
		rc.stopThread();
	}
}
