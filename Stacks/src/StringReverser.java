import java.util.Stack;

public class StringReverser {
	
	public String reverse(String input) {
		if (input == null) 
			throw new IllegalArgumentException();
			
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}
		
		StringBuilder s = new StringBuilder();
		while (!stack.empty()) {
			s.append(stack.pop());
		}
		
		return s.toString();
	}

}
