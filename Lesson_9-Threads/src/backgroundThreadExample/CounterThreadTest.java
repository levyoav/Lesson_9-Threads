package backgroundThreadExample;

import java.util.Scanner;

public class CounterThreadTest {

	public static void main(String[] args) {
		
		CounterThread t1 = new CounterThread();
		t1.start();
		
		//Standard input scanner - gets input from the keyboard by the user.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		
		//Receives input of characters from the keyboard until the return key is hit
		//and stores them as a String in 'name'.
		String name = sc.nextLine();
		
		System.out.print("Enter id: ");
		
		//Receives input of NUMERIC characters from the keyboard until the return key
		//is hit and stores them as an int in 'id'. If a none numeric character is
		//entered, a 'NumberFormatException' is thrown and main ends but the thread t1
		//keeps running until it terminates.
		int id = Integer.parseInt(sc.nextLine());
		
		//If the input was legal and no exceptions were thrown, it is printed out, and
		//thread t1 keeps running until it terminates.
		System.out.println("id = " + id + ", name: " + name);
		
		sc.close(); //Closing the input scanner.
	}
}
