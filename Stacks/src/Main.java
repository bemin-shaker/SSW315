

public class Main {
	public static void main(String[] args) {
		String str = "abcd";
		
		StringReverser reverser = new StringReverser();
		var result = reverser.reverse(str);
		
		System.out.println(result);
		
		
		//
		
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		System.out.println(stack.pop());
		System.out.println(stack);
	}
}
