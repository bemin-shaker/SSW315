//Lab 3

import java.util.Scanner;



public class PromptNumbers {
	public static void arrayPrint(int[] arr) {
		
		System.out.println("Here are the elements of the array in forward order:");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	
	}

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("How many numbers will you enter? ");
		int count = console.nextInt();
		
		int[] store = new int[count];
		int x;
		
		for (int i = 0; i < count; i++) {
			// your code goes here; store the numbers
			System.out.print("Type a number: ");
			x = console.nextInt();
			store[i] = x;
		}
		
		arrayPrint(store);
		

		
	}
	
}