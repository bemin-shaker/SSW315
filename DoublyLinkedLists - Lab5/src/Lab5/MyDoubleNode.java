package Lab5;

public class MyDoubleNode {

	public Object data; 
	public MyDoubleNode next;
	public MyDoubleNode prev;

	public MyDoubleNode(Object data, MyDoubleNode next, MyDoubleNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
