public class MyLinkedList { //Start of class MyLinkedList 
	private Node first;
	
	//LinkList constructor 
	public MyLinkedList() 
	{ 
		first = null; 
		
	}
	
	//Returns true if the linked list is empty 
	public boolean isEmpty() 
	{ 
		return first == null; 
		
	}

	//Inserts a new node at the first of the linked list
	public void addFirst(int d1, double d2) 
	{ 
		Node node = new Node(d1, d2); 
		node.next = first; 
		first = node; 
	}
	
	//Deletes the node at the first of the linked list
	public Node deleteFirst() 
	{ 
		Node temp = first; 
		first = first.next; 
		return temp;
	}
	
	//Prints the linked list data
	public void printList() 
	{ 
		Node currentNode = first; 
		System.out.print("List: "); 
		while(currentNode!= null) 
		{ 
			currentNode. printNode(); 
			currentNode = currentNode.next; 
		} 
		System.out.println(""); 
		
	} 	
} //End of class LinkList

//The following code is to test your linked list.
public class MyLinkedListTest { //Start of class MyLinkedListTest
	public static void main(String[] args) 
	{ 
		MyLinkedList list = new MyLinkedList(); 
		list.addFirst(1, 1.01); 
		list.printList(); 
		list.addFirst(2, 2.02); 
		list.printList(); 
		list.addFirst(3, 3.03); 
		list.printList(); 
		list.addFirst(4, 4.04); 
		list.printList(); 
		list.addFirst(5, 5.05); 
		list.printList(); 
		
		while(!list.isEmpty()) 
		{ 
			Node deletedLink = list.deleteFirst(); 
			System.out.print("deleted: "); 
			deletedLink.printNode(); 
			System.out.println(""); 
		} 
		list.printList(); 	
	}
} //End of class MyLinkedListTest
