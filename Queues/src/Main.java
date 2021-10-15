import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		//Built-in Queue class
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		reverse(queue);
//		System.out.println(queue);
		
		//Queue implemented using circular array
		ArrayQueue newQueue = new ArrayQueue(5);
		newQueue.enqueue(10);
		newQueue.enqueue(20);
		newQueue.enqueue(30);
		newQueue.dequeue();
		var result = newQueue.peek();
//		System.out.println(newQueue);
//		System.out.println(result);
		
		
		//Queue implemented with two stacks
		QueueWithTwoStacks newQueueStack = new QueueWithTwoStacks();
		newQueueStack.enqueue(10);
		newQueueStack.enqueue(20);
		newQueueStack.enqueue(30);
		var first = newQueueStack.dequeue();
		System.out.println(first);
		

	}
	
	public static void reverse(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		
		while(!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		
	}
	
	
}
