package lab6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
//		Given a 5 element queue Q (from front to back:1, 3, 5, 7, 9), 
//		and an empty stack S, remove the elements one-by-one from Q and 
//		insert them into S, then remove them one-by-one from S and 
//		re-insert them into Q.
//		
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(1);
		Q.add(3);
		Q.add(5);
		Q.add(7);
		Q.add(9);
		
		System.out.println("Original queue:" + Q);
		
		Stack<Integer> S = new Stack<Integer>();
		
		while (!Q.isEmpty()) {
			S.push(Q.remove());
		}
		
		System.out.println("New stack S:" +  Q);
		
		while (!S.isEmpty()) {
			Q.add(S.pop());
		}
		
		System.out.println("Queue Q again:" + Q);
	}
}
