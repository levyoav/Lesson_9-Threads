package waitNotifyExample;

public class Test {

	public static void main(String[] args) {

		Stack stack = new Stack();

		Producer p1 = new Producer(stack, "p1");
		Consumer c1 = new Consumer(stack, "c1");
		p1.start();
		c1.start();
	}

}
