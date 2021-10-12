package linkedlists.codewithmosh;

import java.util.NoSuchElementException;

public class LinkedList {
	
	private class Node {
		private int value;
		private Node next; 
		
		public Node(int value) {
			this.value = value;
		}
	}

	
	private Node first; 
	private Node last;
	private int size;
	
	
	public void addLast(int item) {
		Node node = new Node(item); //wrap item around node object
		
		if(isEmpty())  //if empty, point first and last nodes to new node
			first = last = node;
	
		else {
			last.next = node; //add new node after last node
			last = node; //update last to point to new node
		}
		
		size++;
		 
	}
	
	public void addFirst(int item) {
		Node node = new Node(item);
		
		if(isEmpty())
			first = last = node;
		
		else {
			node.next = first;
			first = node;
		}
		
		size++;
		
	}
	
	private boolean isEmpty() {
		return first == null; //checks if first node is empty
	}
	
	public int indexOf(int item) {
		int index = 0;
		var current = first;
		
		while (current != null) {
			if (current.value == item) return index;
			current = current.next;
			index++;
		}
		
		return -1; //list does not contain item

	}
	
	public boolean contains(int item) {
		return indexOf(item) != -1; 
	}
	
	public void removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		if (first == last) { //checks if list has only one element
			first = last = null;
			
		}
		else {
			var second = first.next;
			first.next = null; //removes link
			first = second;
		}
		
		size--;
	} 
	
	public void removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		if (first == last) { //checks if list has only one element
			first = last = null;
		}
		else {
			var previous = getPrevious(last);
			last = previous; //shrinks our list
			last.next = null; //removes link
		}
		
		size--;
	
	}
	
	private Node getPrevious(Node node) {
		var current = first;
		
		while (current != null) {
			if (current.next == node) return current;
			
			current = current.next; //moves forward
		}
		
		return null;
	}
	
	public int size() {
		return size;
	}

	public int[] toArray() {
		int[] newArray = new int[size];
		var current = first;
		var index = 0;
		
		while(current != null) {
			newArray[index] = current.value;
			current = current.next;
			index++;
		}
		
		return newArray;
	}
	
	public void reverse() {
		if (isEmpty()) return;
		
		var previous = first;
		var current = first.next;
		while(current != null) {
			var next = current.next;
			current.next = previous;
			previous = current; //shift forward
			current = next;
		}
		
		last = first;
		last.next = null;
		first = previous; //last element before null
	}
	

}
