package stoppingThreadsExamples;

public class RunnerController {

	//Creating an object of the type Runner (implements Runnable).
	private Runner runner = new Runner();

	//Creating a thread object using the Runner object in the CTOR.
	private Thread t = new Thread(runner, "runner");

	//Starting the thread by invoking the thread's start() method.
	public void startThread(){
		t.start();
	}

	//Stopping the thread by invoking the thread's stopRunning() method.
	public void stopThread() {
		runner.stopRunning();
	}

}
