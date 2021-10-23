import java.util.ArrayList;


class Recursive {
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static ArrayList<Integer> reversedList = new ArrayList<Integer>();

	
    // this one builds a list containing values from 1 to n
    public static ArrayList<Integer> buildList(int n)
    {
    	
        // write this in terms of a recursive call using a smaller n
    	ArrayList<Integer> tempList = null;
    	if (n < 1) {
    		return new ArrayList<Integer>();
    	} else {
    		tempList = buildList(n-1);
    		tempList.add(n);
    		
    		return tempList;
    	}
    	
    }

    // this one reverses a list in-place
    public static void reverse(ArrayList<Integer> lst)
    {
        // write this in terms of a recursive call using a smaller lst
    	
    	if(lst.size() > 1) {                   
    		int temp = lst.get(0);
			lst.remove(0);
			reverse(lst);
			lst.add(temp);
        }
        
    }



   // return the sum of all Integers in the ArrayList; this should not change the lst argument
    public static Integer add(ArrayList<Integer> lst)
    {
        return add(lst,0);
    }

    // Print out all the contents of the argument; this should not change the lst argument
    public static void print(ArrayList<Integer> lst)
    {
        print(lst,0);
        return;
    }

    private static Integer add (ArrayList<Integer> lst, int index)
    {
        // think of the input is the inclusive sublist of elements from index
        // to lst.size(). make this sublist shorter in the recursive call
        //  by incrementing index
    	
    	if (index == lst.size()) {
			return 0;
		}
		return lst.get(index) + add(lst, index + 1);
    }

    private static void print (ArrayList<Integer> lst, int index)
    {
        // write this in the same way as add, above
        // write list printing in the recursive way 
        if (index == lst.size())    // base case: do nothing and return;
        {
        	return;
        } else {            // recursive case: print the item at given index, 
        					//then recursively print the remaining of the list
            System.out.print (lst.get(index) + " ");
            print(lst, index+1);
         
        }
    }
    

	public static void main(String[] args)
	{
	    ArrayList<Integer> lst = Recursive.buildList(5);
	    Recursive.print(lst);
	    System.out.println();
	    reverse(lst);
	    Recursive.print(lst);
	    System.out.println();
	    System.out.println("The list printed in forward order: " + lst);
        reverse(lst);
        System.out.println("The list printed in reverse order: " + lst);
	    System.out.println("The sum of all values from the list is: " + 
	    Recursive.add(lst)); 
	}
}


