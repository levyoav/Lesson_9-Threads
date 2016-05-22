package interruptExample;

//Interrupts a thread that counts up.
public class InterruptedThreadTest {

	public static void main(String[] args) {

		//Creates a thread.
		InterruptedThread t1 = new InterruptedThread("t1");
		t1.start();

		try {
			Thread.sleep(10);

			//Interrupts the thread 't1' from main.
			t1.interrupt();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
