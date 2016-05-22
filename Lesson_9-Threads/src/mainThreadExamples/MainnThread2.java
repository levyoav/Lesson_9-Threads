package mainThreadExamples;

public class MainnThread2 {
	
	public static void main(String[] args) {
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + " - " + Thread.currentThread().getName());
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
