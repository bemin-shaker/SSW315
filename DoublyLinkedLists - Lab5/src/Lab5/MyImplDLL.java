package Lab5;

public class MyImplDLL <E> implements MyDoubleLinkedList {
	
	private MyDoubleNode head;
	private MyDoubleNode tail;
	private int size;
	
	public MyImplDLL() {
		super();
		this.head = new MyDoubleNode(null, null, null);
		this.tail = new MyDoubleNode(null, null, head);
		head.next = tail;
		
		
		this.size = 0;
	}

	
	@Override
	public void insert(Object x) {
		
		if (size == 0) {
			head = new MyDoubleNode(x, tail, null);
		} else if (size == 1) {
	        tail = new MyDoubleNode(x, null, head);
	        head.next = tail;
	    } else {
	        tail.next = new MyDoubleNode(x, null, tail);
	        tail = tail.next;
	    }
	    size++;
	}

	@Override
	public void delete(Object x) {
		
        MyDoubleNode current = head;
        while (current != null) {
            if (current.data.equals(x)) {
                if (current.next == null) { 
                    current.prev.next = null;
                    tail = current.prev;
                } else if (current.prev == null) {
                    current.next.prev = null;
                    head = current.next;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
	}

	@Override
	public boolean lookup(Object x) {
		if (isEmpty()) {
	        return false;
	     }
	     MyDoubleNode current = head;
	     while (current.next != null) {
	        if (current.data.equals(x)) {
	            return true;
	        }
	     current = current.next;
	     }
	        
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void printList() {
		MyDoubleNode current = head;
        StringBuilder str = new StringBuilder("[ ");
        while (current != null) {
            str.append(current.data + ", ");
            current = current.next;
        }
        str.append("]");
        System.out.println(str);

	}

	@Override
	public void printListRev() {
		MyDoubleNode current = tail;
	    StringBuilder str = new StringBuilder("[ ");
	    while (current != null) {
	    	str.append(current.data + ", ");
	        current = current.prev;
	    }
	    str.append("]");
	    System.out.println(str);

	}
	
	public int getSize()
	{
		return size;
	}
}
