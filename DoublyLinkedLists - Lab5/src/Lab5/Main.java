package Lab5;

public class Main {
	public static void main(String a[]){
		  MyImplDLL<Integer> dll = new MyImplDLL<Integer>();
		  dll.insert(10);
		  dll.insert(34);
		  dll.insert(56);
		  dll.insert(364);
		  dll.printList();
		  dll.delete(56);
		  dll.delete(34);
		  dll.printListRev();
		} 
}
