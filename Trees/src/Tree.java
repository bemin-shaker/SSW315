
public class Tree {
	private class Node {
		private int value;
		private Node leftChild;
		private Node rightChild;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	private Node root;
	
	public void insert(int value) {
		var node = new Node(value);
		
		if (root == null) {
			root = node;
			return;
		}
		
		var current = root;
		while (true) {
			if (value < current.value) {
				if (current.leftChild == null) {
					current.leftChild = node;
					break;
				}
				current = current.leftChild; //go one level down to left
			}
			else {
				if (current.rightChild == null) {
					current.rightChild = node;
					break;
				}
				current = current.rightChild; //go one level down to right
			}
		}
	}
}
