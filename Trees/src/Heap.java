
public class Heap {
	private int[] items = new int[10];
	private int size;
	
	public void insert (int value) {
		if (size == items.length)
			throw new IllegalStateException();
		
		items[size] = value;
		size++;
		
		bubbleUp();
	
	}
	
	public void remove() {
		
	}
	
	private void bubbleUp() {
		var index = size - 1;
		while (index > 0 && items[index] > items[parent(index)]) {
			swap(index, parent(index));
			index = (index - 1) / 2;
		}
	}
	
	private int parent(int index) {
		return (index - 1) / 2;
	}
	
	public void swap(int first, int second) {
		var temp = items[first];
		items[first] = items[second];
		items[second] = temp;
	}
}
