package backgroundThreadExample;

//Counts from 0 to 14 every 0.5 sec. and then terminates.
public class CounterThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {

			System.out.println("BOOM!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
