import java.util.LinkedList;

public class BST<E extends Comparable<E>> {
	public class Node {
		private LinkedList<E> data;
		private Node left;
		private Node right;
		
		private Node(E data, Node left, Node right) {
	        this.data = new LinkedList<E>();
	        this.data.add(data);
	        this.left = left;
	        this.right = right;
	    }
		
		private Node(E data) {
			this.data = new LinkedList<E>();
	        this.data.add(data);
	        this.left = null;
	        this.right = null;
	    }

	}
	
	private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }
    
    private Node add(E key, Node current) {
        if (current == null) {
            size++;
            return new Node(key);
        }

        int first = current.data.getFirst().compareTo(key);
        if (first == 0) { 
            current.data.addFirst(key);
            size++;
        } else if (first < 0) {
            current.right = add(key, current.right);
        } else {
            current.left = add(key, current.left);
        }
        return current;
    }
    
    
    public void add(E item) {
        root = add(item, root);
    }
    
    
    private Node remove(E key, Node current) {
        if (current == null) {
            throw new IllegalArgumentException();
        }

        int i = current.data.getFirst().compareTo(key);
        if (i == 0 && current.data.size() == 1) { 
            if (current.left == null) {
                current = current.right;
            } else if (current.right == null) { 
                current = current.left;
            } else {
              current.data = current.left.data;
              current.left = current.left.left;
                
            }
            size--;
        } else if (i == 0 && current.data.size() > 1) {
            current.data.removeFirst();
            size--;
        } else {
            if (i < 0) {
                current.right = remove(key, current.right);
            } else {
                current.left = remove(key, current.left);
            }
        }
        return current;
    }
    
    public void remove(E key) {
        root = remove(key, root);
    }


    private StringBuilder toString(Node current, int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append("-");
        }
        if (current == null) {
            return s.append("*\n");
        } else {
            s.append(current.data + "\n");
            s.append(toString(current.left, n + 1));
            s.append(toString(current.right, n + 1));
        }
        return s;
    }

    public String toString() {
        return toString(root, 0).toString();
    }

}
