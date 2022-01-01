package simulator;

public class MyQueue<E> {
    //Node class for single linked list queue
    private static class Node<E> {
        //Instance variables for Node
        private E data;
        private Node<E> next;

        //Constructor for Node, to be completed by you
        private Node(E dataItem) { 
        	this.data = dataItem;
        	next = null;
        }

        //Constructor for Node, to be completed by you
        private Node(E dataItem, Node<E> nodeRef) { 
        	this.data = dataItem;
        	this.next = nodeRef;
        }
    }

    //Instance variables for queue
    private Node<E> front;
    private Node<E> rear;
    private int size;

    //Constructor for queue, to be completed by you
    public MyQueue () {  
    	front = rear = null;
    	size = 0;
    }

    //Adds a node to queue, to be completed by you
    public boolean offer(E item) {  
    	Node<E> node = new Node<E>(item);
    	
    	if (rear == null) {
    		front = rear = node;
    	}
    	else if (front == rear) {
    		front.next = node;
    		rear = front.next;
    	} else {
    		rear.next = node;
        	rear = node;
    	}
    	
    	
    	size++;
    	return true;
    }
    

    //Returns the node at front of queue, to be completed by you
    public E peek() { 
    	if (front == null)
    		throw new IllegalStateException();
    	return front.data;
    }

    //Returns and removes the node at front of queue, to be completed by you
    public E poll() {
    	if (front == null)
    		throw new IllegalStateException();
    	
    	E temp = front.data;
    	
    	if (front == rear) {
    		front = rear = null;
    		return temp;
    	}
    	else {
    		var second = front.next;
    		front.next = null; //removes link from front node
        	front = second;
    	}
    	
    	size--;
    	return temp;
    	
    }

    //Returns the data element at a specific index, to be completed by you
    public E get(int index) { 
    	if (size == 0) {
              throw new IllegalStateException();
          }
    	Node<E> current = front;
    	for (int i=0; i < index; i++) {
    		current = current.next;
    	}
    	
    	return current.data;
    }

    //Returns the size of the queue, to be completed by you
    public int size() {		
    	return size;
    }
}
